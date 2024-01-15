# Composite pattern

* when you have heirarchical relations between objects
* for example
  * Department
    * sales
    * it
    * head
      * finance
      * management

* here you can see head department itself contains other departements, to represent such composite relations, composite design pattern is used

* this pattern contains three main components
  * Component -> Department, sales
  * Leaf -> finance
  * Composite -> addDepartment
                 removeDepartment