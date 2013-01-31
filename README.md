SwornRPG
========

Introducing SwornRPG, the fully functional, highly customizable alternative to McMMO!
This plugin features such things as admin only chat, rare drops, a leveling system*, frenzy mode*, riding of other players, and much more!
(Optional TagAPI integration, see below)

Commands:
  admin chat:
    command: /a <msg>
    permission: srpg.adminchat
    description: Admin chat
  ride:
    command: /ride <player>
    permission: srpg.ride
    description: Ride another player
  hat:
    command: /hat
    permission: srpg.hat (granted by default)
    description: Put the block in your hand on as your hat
  srpg:
    command: /srpg
    aliases: /swornrpg
    permission: n/a
    description: Root command
permissions:
  srpg.admin:
    description: Gives access to features meant for server admins.
    children:
      srpg.moderator: true
      srpg.asay: true
  srpg.moderator:
    description: Gives access to features meant for server moderators.
    children:
      srpg.guard: true
      srpg.ride: true
  srpg.guard:
    description: Gives access to features meant for server guards.
    children:
      srpg.adminchat: true
  srpg.hat:
    description: Changes your hat.
    default: true
More to come in future releases ;3
