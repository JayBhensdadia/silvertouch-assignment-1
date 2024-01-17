# Visitor Pattern


* allows you to add new operations to existing class without changing their structure
* it is achieved by separating operation(method) from objects
* Visitor -> visit(Element e)
* Element -> accept(Visitor v){ v.visit(this) }