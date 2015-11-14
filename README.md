BlockServer [![Build Status](https://travis-ci.org/BlockServerProject/BlockServer.svg?branch=master)](https://travis-ci.org/BlockServerProject/BlockServer) [![Build Status](http://teamcity.beaconpe.net/app/rest/builds/buildType:BlockServer_Build/statusIcon)]
===========

[![Visit our IRC channel](https://kiwiirc.com/buttons/irc.freenode.net/blockserverproject.png)](https://kiwiirc.com/client/irc.freenode.net/?nick=blockserver|?#blockserverproject)

# FAQ

## What is BlockServer?
BlockServer is a free, open-source Minecraft: PE server software.

## Does BlockServer only support MCPE?
If you download BlockServer only, yes. But if you inject extra code into BlockServer, new protocols will be registered in the server software and it can support players connecting from **any** protocols, including non-minecraft protocols.

## Is BlockServer ready to use?
Unfortunately, no. Currently, BlockServer is still in early development stage that cannot work yet (due to a recent rewrite). We expect it to be easily usable soon, however.

## How do I run BlockServer when it is ready?
* If you download an archived `.jar` file, you can run the jar directly with the `java -jar <jar file>` command.
* You can also compile the source using Maven. Maven will handle all the dependencies for you, no extra downloads needed.
Then run `java org.blockserver.run` in the root folder where the compiled classes are contained in.

## Can I contribute code?
Of course yes! We need your help! However, before writing code, please read our [contribution guidelines](https://github.com/BlockServerProject/BlockServer/blob/new/CONTRIBUTING.md) first.
