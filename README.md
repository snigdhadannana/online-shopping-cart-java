Online Shopping Cart Simulation
This project is a console-based application that simulates a basic e-commerce shopping experience. Users can browse a list of products loaded from a file, add them to a virtual shopping cart, view the contents and total cost of their cart, and proceed through a mock checkout process.

🚀 Features
Product Catalog: Displays a list of available products with their names, prices, and descriptions. Products are loaded from a products.csv file.

Add to Cart: Allows users to select products and add a specified quantity to their shopping cart.

View Cart: Shows all items currently in the shopping cart, including quantities and individual item totals.

Cart Total Calculation: Automatically calculates the subtotal and grand total of all items in the cart.

Remove from Cart: Provides functionality to remove items or adjust quantities in the cart.

Mock Checkout: Simulates the final purchase process (without actual payment integration).

🛠️ Technologies Used
Primary Language: Java

Core Libraries: java.io (for file handling), java.util (for data structures like HashMap, ArrayList, Scanner).

Data Structures: List (for products, cart items), Map (for inventory management).

Object-Oriented Programming (OOP): Core design principles are heavily utilized.

Input/Output: Standard console I/O for user interaction.

📦 Project Structure
online-shopping-cart-simulation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── example/
│   │   │   │       └── shoppingcart/
│   │   │   │           ├── model/
│   │   │   │           │   ├── Product.java
│   │   │   │           │   └── CartItem.java
│   │   │   │           ├── service/
│   │   │   │           │   └── ShoppingCart.java
│   │   │   │           └── Main.java
├── products.csv            <-- This file contains your product data
├── .gitignore
├── README.md
├── LICENSE (optional)

⚙️ How to Run
Clone the repository:

git clone https://github.com/your-username/online-shopping-cart-simulation.git

Navigate to the project directory:

cd online-shopping-cart-simulation

Create products.csv: In the root directory (online-shopping-cart-simulation/), create a file named products.csv. Populate it with product data, one product per line, in the format: ID,Name,Price,Description. Example products.csv content:

P001,Laptop,1200.00,High-performance laptop
P002,Wireless Mouse,25.50,Ergonomic wireless mouse
P003,Mechanical Keyboard,85.00,RGB mechanical keyboard
P004,Monitor 27-inch,300.00,Full HD IPS monitor
P005,USB-C Hub,45.00,Multi-port USB-C adapter
P006,Smartphone,799.99,Latest model smartphone
P007,Headphones,150.00,Noise-cancelling headphones
P008,Smartwatch,249.00,Fitness tracker and smartwatch

Compile the Java files: Navigate to the src/main/java directory:

cd src/main/java

Then compile:

javac com/example/shoppingcart/model/*.java com/example/shoppingcart/service/*.java com/example/shoppingcart/*.java

(Alternatively, if your shell supports it, you can use javac com/example/shoppingcart/**/*.java)

Run the application: From the src/main/java directory:

java com.example.shoppingcart.Main

(You can also run from the project root by setting the classpath: java -cp src/main/java com.example.shoppingcart.Main)

💡 Design Principles & OOP Concepts Demonstrated
Encapsulation: Product details (name, price) are encapsulated within the Product class. Cart logic is encapsulated within the ShoppingCart class.

Abstraction: Users interact with high-level functions like "add to cart" without needing to know the underlying implementation details.

Classes & Objects: Clear separation of concerns using classes like Product, ShoppingCart, and CartItem.

State Management: The ShoppingCart class effectively manages the state of items added by the user.

Error Handling: Includes basic input validation and file reading error handling.

📈 Future Enhancements
User Authentication: Implement user login/registration.

Persistent Cart Data: Save user carts to a file or database.

Discount Codes: Apply discounts to the total cart value.

Multiple Payment Methods: Offer mock options for different payment types.

Order History: Allow users to view past purchases.

Inventory Management: Track product stock and prevent over-selling.

Graphical User Interface (GUI): Convert the console application into a desktop GUI application (e.g., using Swing/JavaFX).

Backend Integration: Develop a RESTful API with a database (e.g., Spring Boot, Node.js with Express) and connect a web frontend.

🤝 Contributing
Feel free to fork this repository, make improvements, and submit pull requests. Any contributions are welcome!


