# OreTrees (Rebuilt from decompiled sources)

NeoForge 1.21.1 mod recovered from published `.class` files in
https://github.com/NeofastFTL-Dev/OreTrees

## Package

Actual bytecode package is `com.nftl.oretrees` (GitHub folders used `com/neofastftl/...`).

## Requirements

- Java 21
- **At least 4 GB RAM** for the first Gradle run (NeoForge decompiles Minecraft with Vineflower)
- Internet (downloads NeoForge, Minecraft, mappings)

## Build

```bash
chmod +x gradlew
./gradlew build
```

Output jar: `build/libs/oretrees-1.0.0.jar`

## Run client (dev)

```bash
./gradlew runClient
```

## Notes

- Sources were decompiled with CFR 0.152; some casts and control flow are noisy but should compile.
- JEI plugin was moved to `src/optional/jei/` (add JEI dependency and move back if you want JEI subtypes).
- Config is mostly leftover MDK template (magic number, log dirt, etc.).
- Worldgen / loot / recipes / models come from the original resources and are intact.
- `mod_license` is still "All Rights Reserved" from the original repo.

## Tree types

DIRT, PETRIFIED, SAND, GRAVEL, CLAY, COAL, IRON, GOLD, REDSTONE, LAPIS,
DIAMOND, EMERALD, QUARTZ, COPPER, TIN, ALUMINUM, LEAD, SILVER, NICKEL,
PLATINUM, URANIUM, OSMIUM, ZINC

Blocks (log / leaves / sapling) are single registrations differentiated by the
`tree_type` data component + blockstate property.
