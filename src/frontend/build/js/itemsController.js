export default class ItemsController {
  constructor(currentId = 0) {
    this.items = [];
    this.currentId = currentId;
  }

  addItem(name, description, imageUrl) {

    const item = {

      id: this.currentId++,
      name: name,
      description: description,
      imageUrl: imageUrl

    };

    this.items.push(item);
    this.save({name, description, imageUrl});
       
}

save({name, description, imageUrl}){
    const data = { name,  description, imageUrl };

    fetch('http://localhost:8080/item', {
    method: 'POST', 
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data => {
    console.log('Success:', data);
    })
    .catch((error) => {
    console.error('Error:', error);
    });
}




update({name, description, imageUrl}){
    const data = { name,  description, imageUrl };

    fetch('http://localhost:8080/item', {
    method: 'PUT', 
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data => {
    console.log('Success:', data);
    })
    .catch((error) => {
    console.error('Error:', error);
    });
}

    getItems(){
    const urlToFetch = `http://localhost:8080/item`;
    const listItems = document.getElementById("list-items");
    listItems.innerHTML = ``;
    fetch(urlToFetch, { cache: "no-cache" })
      .then(
        (response) => {
          if (response.ok) {
            return response.json();
          }
          throw new Error("Request failed!");
        },
        (networkError) => {
          console.log(networkError.message);
        }
      )
      .then((jsonResponse) => {
        const items = jsonResponse;
        addItemCard(items);
     });
  };


    async delete ({id}) {
    const urlToFetch = `http://localhost:8080/item` + id;
    try {
      const response = await fetch(urlToFetch, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      });
      if (response.ok) {
        window.location.reload();
      }
    } catch (error) {
      console.log(error);
    }
  };

    saveItemsToLocalStorage() {
        if(!localStorage.getItem("items")) {
            localStorage.setItem("items", JSON.stringify(this.items));
        } else {
            const localStorageAgain = JSON.parse(localStorage.getItem("item"));
            localStorageAgain.push(this.items[this.items.length - 1]);
            localStorage.setItem('items', JSON.stringify(this.items)); 
        }
    }

   loadItemsFromLocalStorage() {
    const storageItems = localStorage.getItem('items')
    if (storageItems) {
      const items = JSON.parse(storageItems)
      for (var i = 0; i < items.length; i++) {
        const item = items[i];
        this.items.push(item);
      }
    }
  }
}

// const controller = new ItemsController();
// controller.name = 'car';
// controller.description = 'blue';
// controller.imageUrl = 'https://www.pexels.com/photo/blue-bmw-sedan-near-green-lawn-grass-170811/';

// controller.addItem("car", "blue", "https://www.pexels.com/photo/blue-bmw-sedan-near-green-lawn-grass-170811/");
// controller.items.push("car", "blue", "https://www.pexels.com/photo");


// console.log(controller);
// console.log(controller.items);
