Keywords: PC component mapping, Real-time inventory tracking, Interactive map, PC building, Hardware locator, Retailer integration


Summary:
This project aims to create a web-application that combines mapping technology with real-time inventory tracking for PC components at major retailers. Users can search for specific parts, filter by component type, and view local stores with available stock on an interactive map. The web-app integrates with Best Buy, Walmart, and Microcenter APIs to provide inventory data and includes features such as automatic location detection, budget filtering, and compatibility checking. This tool will enhance the PC building process by helping PC builders find the best deals on computer hardware in their area.

The motivation behind this project stems from the challenges faced by PC builders in sourcing components quickly and cost-effectively. When building or repairing PCs, users encounter situations where they need parts immediately and can’t wait for delivery times. Furthermore, shipping costs can be an obstacle, especially for those on a budget. Hardware Hunter addresses these issues by providing a platform that allows users to view multiple options across various major retailers with a map element, helping them locate nearby stores with the required components in stock. This tool will not only save time and money for PC builders but also provide a more efficient approach to pc component shopping.


Based on research here are some possible options for our stack:
Front-end: HTML, CSS, and JavaScript
Back-end: Node.js & Express.js framework
Map integration: Google Maps JavaScript API or OpenStreetMap API
Retailer APIs: Best Buy Products API, Walmart API, and the custom Microcenter stock checker on Github
Database: MongoDB

Features
Map Interface
Implement a Google Maps-like interface for displaying nearby stores
Display inventory information for specific pc parts when stores are clicked on  

Part Filtering and Search Functionality
Include buttons for filtering PC component categories (CPU, GPU, RAM, etc.)
Implement a search function for finding specific parts
	 
Budgeting
Allow users to set price limits for their components 
Automatically filter results based on the user's budget  

Optional Features
Compatibility Checking for multiple parts
Develop a system to ensure selected parts are compatible with each other
Alternative (create a shopping cart that saves the parts and automatically inputs them to PCPartPicker.com with a redirect URL) 
