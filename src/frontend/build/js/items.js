import ItemsController from "./itemsController.js";
// export { itemsController, addItemCard, loadStorageSampleData, loadCardsListFromItemsController };

const itemsController = new ItemsController(0);


function addItemCard(item) {
  //function add the html card with info about an item to a page;
  const itemHtml = `<div class="card mx-5" style="width: 16rem;">
    <img src="${item.imageUrl}>  
    <div class="card-body">
      <h5 class="card-title">${item.name}</h5>
      <p class="card-text">${item.description}</p>
      <a href="#" class="btn btn-primary">Shop Now</a>
    </div>
  </div>`;
  // variable cardHtml recieved an html card with properties from the item object - img, name and description;
  const itemsContainer = document.getElementById("list-items");
  itemsContainer.innerHTML += itemHtml;
  //variable from line 1 of this code cardOutput receives an html card as an innerHTML;
}
// Modify the items.js so it calls the loadItemsFromLocalStorage() and then iterate the ItemsController.items list to load the items into your items.html page using the function implemented from addItemCard(item)
// loadItemsFromLocalStorage(); {
//   const storageItems = localStorage.getItem('items')
//   if (storageItems) {
//     const items = JSON.parse(storageItems);
//     for (var i = 0; i < items.length; i++) {
//       const item = items[i];
//       this.items.push(item);
//     }
//   }
// }

// function loadStorageSampleData() {
//   if (!localStorage.getItem("items")) {
//     const sampleItems = [{
//       'name': 'juice',
//       'img': 'https://www.gs1india.org/media/Juice_pack.jpg',
//       'description': 'Orange and Apple juice fresh and delicious'
//     },
//     {
//       'name': 'Ruffles Chicken',
//       'img': 'https://s3-ap-southeast-1.amazonaws.com/www8.fairprice.com.sg/fpol/media/images/product/XL/13086598_LXL1.jpg',
//       'description': 'Ruffles Potato Chips - Chicken'
//     }];
//     localStorage.setItem("items", JSON.stringify(sampleItems));
//   }
// }

function loadCardsListFromItemsController() {
  for (var i = 0, size = itemsController.items.length; i < size; i++) {
    const item = itemsController.items[i];
    addItemCard(item);
  }
}

// loadStorageSampleData();

itemsController.loadItemsFromLocalStorage();
loadCardsListFromItemsController();
console.log(itemsController.items);