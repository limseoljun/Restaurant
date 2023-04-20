function setInitialTotalPrice() {
    var totalBasketPrice = 0;
    var totalPrices = document.querySelectorAll('.total-price');
    for (var i = 0; i < totalPrices.length; i++) {
        totalBasketPrice += parseFloat(totalPrices[i].textContent);
    }
    document.getElementById('basket-price').textContent = Math.floor(totalBasketPrice);
}

function updateTotalPrice(input) {
    // Get the price of the food
    var price = input.parentNode.previousElementSibling.textContent;

    // Calculate the total price based on the count and price of the food
    var count = input.value;
    var totalPrice = price * count;

    // Set the total price in the corresponding div
    input.parentNode.nextElementSibling.textContent = totalPrice;

    // Calculate the total basket price
    var totalBasketPrice = 0;
    var totalPrices = document.querySelectorAll('.total-price');
    for (var i = 0; i < totalPrices.length; i++) {
        totalBasketPrice += parseFloat(totalPrices[i].textContent);
    }

    // Set the total basket price in the corresponding span
    document.getElementById('basket-price').textContent = Math.floor(totalBasketPrice);
}