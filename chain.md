@startuml Chain_of_Responsibility

skinparam classAttributeIconSize 0
skinparam defaultFontName Arial
skinparam linetype ortho

abstract class DefenseHandler {
- next : DefenseHandler
--
+ setNext(next : DefenseHandler) : DefenseHandler
# getNext() : DefenseHandler
# passToNext(damage : int, target : ArenaFighter) : void
+ {abstract} handle(incomingDamage : int, target : ArenaFighter) : void
}

class DodgeHandler {
- dodgeChance : double
- random : Random
--
+ handle(incomingDamage : int, target : ArenaFighter) : void
}

class BlockHandler {
- blockPercent : double
--
+ handle(incomingDamage : int, target : ArenaFighter) : void
}

class ArmorHandler {
- armorValue : int
--
+ handle(incomingDamage : int, target : ArenaFighter) : void
}

class HpHandler {
--
+ handle(incomingDamage : int, target : ArenaFighter) : void
}

DefenseHandler o--> DefenseHandler : next >

DodgeHandler  --|> DefenseHandler
BlockHandler  --|> DefenseHandler
ArmorHandler  --|> DefenseHandler
HpHandler     --|> DefenseHandler

note right of DodgeHandler
Stops chain on
successful dodge
end note

note right of HpHandler
Terminal — never
calls passToNext
end note

@enduml