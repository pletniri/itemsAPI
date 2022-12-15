import ItemsController from "./itemsController.js";
// import { itemsController, addItemCard } from "./items.js";

//this is the main js file 

// Initialize a new TaskManager with currentId set to 0
const itemsController = new ItemsController(0);

const newItemForm = document.querySelector('#newItemForm');
const showData = document.getElementById('show-data');
// const event = document.getElementById('submit');

newItemForm.addEventListener('submit', (event) => {
    // prevent default action
    event.preventDefault();

    //select the inputs fields
    const newItemName = document.querySelector('#newItemName');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemImageUrl = document.querySelector('#newItemImageUrl');

    //get the values of the input fields
    const name = newItemName.value;
    const description = newItemDescription.value;
    const imageUrl = newItemImageUrl.value;

    //Add the item to the itemscontroller array 
    itemsController.addItem(name, description, imageUrl);
    itemsController.saveItemToLocalStorage();
    itemsController.loadItemsFromLocalStorage();
    console.log(itemsController.items);

    //clear the form fields
    newItemName.value = '';
    newItemDescription.value = '';
    imageUrl.value = '';
    window.location.href = "../product.html";

});


function addItemCard(item) {
    const itemHTML = '<div class="card" style="width: 18rem;">\n' +
        '    <img src="' + item.img + '" class="card-img-top" alt="image">\n' +
        '    <div class="card-body">\n' +
        '        <h5 class="card-title">' + item.name + '</h5>\n' +
        '        <p class="card-text">' + item.description + '</p>\n' +
        '        <a href="#" class="btn btn-primary">Add</a>\n' +
        '    </div>\n' +
        '</div>\n' +
        '<br/>';
    const itemsContainer = document.getElementById("list-items");
    itemsContainer.innerHTML += itemHTML;
}

addItemCard({
    'name': 'juice',
    'img': 'https://www.gs1india.org/media/Juice_pack.jpg',
    'description': 'Orange and Apple juice fresh and delicious'
});

addItemCard({
    'name': 'Tayto',
    'img': 'https://www.irishtimes.com/polopoly_fs/1.4078148!/image/image.jpg',
    'description': 'Cheese & Onion Chips'
})