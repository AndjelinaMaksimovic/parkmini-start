# ParkMini: početni projekat za časove

Ovo je **prazan početni projekat** za časove uvoda u Kotlin. Na časovima kucamo kod zajedno: server (Ktor) i Android aplikaciju (Jetpack Compose).
Aplikacija je mali parking sa mestima koja menjaju boju uživo.

## Kako da počneš

1. Instaliraj sve prema [INSTALACIJA.md](INSTALACIJA.md) (obavezno pre prvog časa).
2. Preuzmi projekat:
   ```bash
   git clone https://github.com/AndjelinaMaksimovic/parkmini-start
   ```
3. U IntelliJ-u: `File → Open` → izaberi folder `parkmini-start` (koren) → **Trust Project** → sačekaj Gradle sync (prvi put traje nekoliko minuta).
4. Provera: izaberi konfiguraciju **`android`**, pokreni na emulatoru: treba da piše „Hello, ParkMini!“.

## Struktura

| Folder | Šta |
|---|---|
| `shared/` | modeli koje koriste i server i aplikacija (kucamo na času 2) |
| `backend/` | server (časovi 1 do 3) |
| `android/` | aplikacija (časovi 4 do 6) |
| `given/` | gotovi fajlovi koje dobijaš u toku časa. **Ne otvaraj ih unapred**, nego ih ubaciš kad stignemo do tog zadatka. |

Zadatke dobijaš na času. Sve ostalo kucamo zajedno.
