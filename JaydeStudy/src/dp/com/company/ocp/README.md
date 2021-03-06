#开闭原则(OCP:Open-Closed Principle)
定义：一个软件实体应当对扩展开放，对修改关闭。即软件实体应尽量在不修改原有代码的情况下进行扩展。

根据开闭原则，在设计一个软件系统模块（类，方法）的时候，应该可以在不修改原有的模块（修改关闭）的基础上，能扩展其功能（扩展开放）。遵循开闭原则的系统设计，可以让软件系统可复用，并且易于维护。这也是系统设计需要遵循开闭原则的原因：  
 1.稳定性。开闭原则要求扩展功能不修改原来的代码，这可以让 软件系统在变化中保持稳定。  
 2.扩展性。开闭原则要求对扩展开放，通过扩展提供新的或改变原有的功能，让软件系统具有灵活的可扩展性。  
 
##如何使用开闭原则
 * 抽象约束。首先通过接口或抽象类约束扩展，对扩展进行边界限定，不允许出现在接口或抽象类中不存在的public方法；第二，参数类型，引用对象尽量使用接口或者抽象类，而不是实现类；第三，抽象层尽量保持稳定，一旦确定既不允许修改。
 * 元数据(metadata)控制模块行为。尽量使用元数据(用来描述环境和数据的数据，通俗的说就是配置参数)来控制程序的行为，减少重复开发。
 * 制定项目章程。对于项目来说，约定优于配置。
 * 封装变化。第一，将相同的变化封装到一个接口或抽象类中；第二，将不同的变化封装到不同的接口或抽象类中，不应该有两个不同的变化出现在同一个接口或抽象类中。