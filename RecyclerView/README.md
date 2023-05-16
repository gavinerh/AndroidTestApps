## Difference between the 2 ways of adding a click listener in Recycler view
### Both version similarity:
- onclick listener is implemented in main_activity.java
- Declared and created a custom ItemClickListener interface
### Version 1:
- ItemclickListener initialised obj is stored in customAdapter
- When the item is clicked, the onclick method is called in customAdapter class, in the method onBindViewHolder
### Version 2:
- ItemClickListener interface is stored in customAdapter and passed a copy to customViewHolder
- When the item is clicked, the onclick method is called in the customViewHolder class

