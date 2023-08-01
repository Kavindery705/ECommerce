function addtocart(pid,pname,pprice){
	
	let cart = localStorage.getItem("cart");
	if(cart==null){
		let products = [];
		let product ={productId:pid,productName:pname,productQuantity:1,productPrice:pprice}
		products.push(product);
		localStorage.setItem("cart",JSON.stringify(products));
	}
	else{
		let pcart = JSON.parse(cart);
		let oldProduct =pcart.find((item)=>item.productId ==pid);
		if(oldProduct){
			oldProduct.productQuantity = oldProduct.productQuantity +1;
			pcart.map((item)=>{
				if(item.productId==oldProduct.productId){
					item.productQuantity = oldProduct.productQuantity;
				}
			})
			localStorage.setItem("cart",JSON.stringify(pcart))
		}
		else{
			let product ={productId:pid,productName:pname,productQuantity:1,productPrice:pprice}
			pcart.push(product);
			localStorage.setItem("cart",JSON.stringify(pcart))
		}
	}
	updateCart()
}

function updateCart(){
	let cartstring = localStorage.getItem("cart");
	let cart1=JSON.parse(cartstring);
	if(cart1==null || cart1.length==0){
		console.log("cart is empty!!")
		$(".cart-items").html("(0)");
		$(".cart-body").html("<h3>cart does not have any items</h3>");
		$(".checkout-btn").attr('disabled',true);
	}
	else{
		console.log(cart1);
		$(".cart-items").html(`${cart1.length}`);
		$(".checkout-btn").attr('disabled',false);
		let table=`
		<table class='table'>
		<thead class='thread-light'>
		<tr>
		<th>Item Name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Total Price</th>
		<th>Action</th>
		</tr>
		</thead>`;
		let totalprice =0;
		cart1.map((item)=>{
			table +=`
			<tr>
			<td>${item.productName}</td>
			<td>${item.productPrice}</td>
			<td>${item.productQuantity}</td>
			<td>${item.productQuantity*item.productPrice}</td>
			<td><button class='btn btn-danger btn-sm' onclick='deleteItem(${item.productId})'>Remove</button>
			</tr>`; 
			totalprice +=item.productPrice * item.productQuantity;
		})
		table = table + `
		<tr><td colspan="5" class="text-right font-weight-bold">Total Price : ${totalprice}</td></tr>
		</table>`
		$(".cart-body").html(table);
	}
}

function deleteItem(pid){
	
	let cart=JSON.parse(localStorage.getItem("cart"));
	let newcart =cart.filter((item)=>item.productId !=pid)
	localStorage.setItem('cart',JSON.stringify(newcart))
	updateCart();
}

function gotocheckout(){
	window.location="checkout.jsp"
}

function continueShop(){
	window.location="index.jsp"
}
$(document).ready(function (){
	updateCart()
	
})