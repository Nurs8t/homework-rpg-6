@startuml Command_Pattern

skinparam classAttributeIconSize 0
skinparam defaultFontName Arial
skinparam linetype ortho

interface ActionCommand {
+ execute() : void
+ undo() : void
+ getDescription() : String
}

class AttackCommand {
- target : ArenaOpponent
- attackPower : int
- damageDealt : int
--
+ execute() : void
+ undo() : void
+ getDescription() : String
}

class HealCommand {
- target : ArenaFighter
- healAmount : int
- actualHealApplied : int
--
+ execute() : void
+ undo() : void
+ getDescription() : String
}

class DefendCommand {
- target : ArenaFighter
- dodgeBoost : double
--
+ execute() : void
+ undo() : void
+ getDescription() : String
}

class ActionQueue {
- queue : List<ActionCommand>
--
+ enqueue(cmd : ActionCommand) : void
+ undoLast() : void
+ executeAll() : void
+ getCommandDescriptions() : List<String>
}

AttackCommand  ..|> ActionCommand
HealCommand    ..|> ActionCommand
DefendCommand  ..|> ActionCommand

ActionQueue o-- ActionCommand : uses >

@enduml