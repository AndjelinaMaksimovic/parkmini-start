# Instalacija: šta treba da imaš pre prvog časa

Sve se radi u **IntelliJ IDEA** (server, Android, testiranje). Uradi ovo **kod kuće i pre časa**: prvo pokretanje preuzima stotine MB.

## 1. Šta instaliraš

| Šta | Napomena |
|---|---|
| **IntelliJ IDEA** | poslednja stabilna verzija. Zatim `Settings → Plugins → Marketplace → "Android"` → Install (plugin firme JetBrains). |
| **JDK 21** | `File → Project Structure → SDKs → + → Download JDK` → Eclipse Temurin 21. |
| **Android SDK** | `Settings → Languages & Frameworks → Android SDK` → označi **Android 16 (API 36)** i **Build-Tools**, pa Apply. |
| **Emulator** | `View → Tool Windows → Device Manager → Create Virtual Device` → Pixel → slika *Google APIs, API 36* (Windows/Intel: x86_64, Apple Silicon: ARM 64). Na **Windows-u** emulator traži uključenu virtuelizaciju u BIOS-u i funkciju *Windows Hypervisor Platform*. Ako ne ide, koristi **telefon sa USB kablom** (uključi *USB debugging*). |
| **Git** | https://git-scm.com (na Windows-u "Git for Windows"). |

## 2. Preuzmi projekat

```bash
git clone https://github.com/AndjelinaMaksimovic/parkmini-start
```

U IntelliJ-u: `File → Open` → izaberi folder `parkmini-start` (koren) → **Trust Project** → sačekaj da Gradle sync završi (traka dole). Ako traži putanju do Android SDK-a, ona je u `Settings → Languages & Frameworks → Android SDK` (gore piše "Android SDK Location").

## 3. Provera (obavezno pre prvog časa)

1. Pokreni emulator: `View → Tool Windows → Device Manager` → ▶ pored tvog telefona.
2. Gore, pored zelenog trougla, izaberi konfiguraciju **`android`** i klikni ▶.
3. Na telefonu treba da piše **„Hello, ParkMini!“**. Ako piše, sve je spremno.

## 4. Ako nešto ne radi

| Problem | Rešenje |
|---|---|
| Gradle javlja grešku o JDK-u | `Settings → Build Tools → Gradle → Gradle JVM` → izaberi JDK 21. |
| Nema konfiguracije `android` gore | Gradle sync nije završen: klikni ikonicu slona (*Sync*) i sačekaj. |
| Emulator je spor ili ne radi | Koristi telefon preko USB-a, ili prati sa predavačevog ekrana. |
| U emulatoru ne može da se kuca (vidi se uzana traka sa mikrofonom umesto tastature) | Emulator prijavljuje miš kao olovku. U emulatoru: `Settings → System → Keyboard → On-screen keyboard → Gboard → Handwriting` → ugasi **Use stylus to write in text fields**. |
| IntelliJ upozorava na „ranjivosti“ biblioteka | Za ovaj primer nisu važne, ignoriši. |

Aplikacija na emulatoru pristupa serveru na tvom računaru preko adrese `10.0.2.2:8080` (već je podešeno), a Windows firewall može prvi put da pita da li dozvoljavaš Javi mrežu: **dozvoli**.
