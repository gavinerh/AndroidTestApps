## Difference between the 2 ways of adding a click listener in Recycler view
### Both version similarity:
- onclick listener is implemented in main_activity.java
- Declared and created a custom ItemClickListener interface
### Version 1:
- ItemclickListener initialised obj is stored in customAdapter
- When the item is clicked, the onclick method is called in customAdapter class, in the method onBindViewHolder
- Implement an anonymous View.OnClickListener in the customAdapter.onBindViewHolder method, which will call the implemented method of ItemClickListener interface in MainActivity.java
### Version 2:
- ItemClickListener interface is stored in customAdapter and passed a copy to customViewHolder
- When the item is clicked, the onclick method is called in the customViewHolder class
- The class cusViewHolder is made to implement the View.OnClickListener, which will call the implemented method of ItemClickListener interface in MainActivity.java

