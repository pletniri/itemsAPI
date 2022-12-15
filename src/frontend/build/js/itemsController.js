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

    localStorage.setItem('items', JSON.stringify(this.items));

    this.save({name, description, imageUrl});

    
}

save({name, description, imageUrl}){
    const data = { name,  description, imageUrl };

    fetch('http://localhost:8080/item', {
    method: 'POST', // or 'PUT'
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

}

delete(itemId){

}

findById(itemId) {
    
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

const controller = new ItemsController();
// controller.name = 'car';
// controller.description = 'blue';
// controller.imageUrl = 'https://www.pexels.com/photo/blue-bmw-sedan-near-green-lawn-grass-170811/';

controller.addItem("car", "blue", "https://www.pexels.com/photo/blue-bmw-sedan-near-green-lawn-grass-170811/");
controller.items.push("car", "blue", "https://www.pexels.com/photo");


console.log(controller);
console.log(controller.items);
