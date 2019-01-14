# Smart Real Estate
## Bemutatás
Nagyon sokan vannak az online hirdető portálokon, akik nem tudnak egy jó, csábító hirdetést összerakni: ez különösen akkor hátrányos, ha egy nagy értékű tételről, például egy lakásról van szó. Ezért egy olyan alkalmazást készítek, ami egy online ingatlanértékesítő portál hirdetésfeladó mobilalkalmazását szimulálja, mely képes arra, hogy megjósolja, hány megtekintést fog elérni a feladott hirdetésünk.
## Főbb funkciók
Az alkalmazásba a felhasználó képes új lakás hirdetését létrehozni, az adatokat megadva és a képeket a telefonjáról kiböngészve.
Az alkalmazás a hirdetés létrehozása közben egy szerver REST végpontjával kommunikál, ami képes megmondani, hogy a jelenlegi kitöltöttség alapján hány megtekintésre számíthat a hirdető. Ez a funkció a beállítások közt kikapcsolható.
Az alkalmazás lokálisan tárolja az általunk létrehozott hirdetéseket, ezek közt böngészni lehet és módosításokat, törléseket végezni.
Az alkalmazás néha tippekkel látja el a felhasználót, hogy hogyan növelhetné a hirdetés által elért felhasználókat.
(A hirdetések online feltöltése egyelőre nem valósul meg, ezeknek a funkcióknak legfeljebb placeholderek kerülnek be az alkalmazásba.)
## Technológiák
*	**UI**: Az alkalmazás felhasználói felülete: Activity-k, Fragmentek indítására.
*	**Recyclerview**: Az alkalmazás RecyclerView segítségével jeleníti meg a feltöltött hirdetések listáját.
*	**Hálózatkezelés**: Az alkalmazás egy saját szerverrel kommunikál és REST végponton keresztül küldi el a hirdetés adatait és kapja vissza a várható látogatószámot.
*	**Adatbáziskezelés**: A felhasználó elmenti a feladott hirdetéseket lokálisan.
*	**Notificationök**: Az alkalmazás néha értesítéseket küld arról, hogy hogyan lehetne növelni a hirdetéssel elért emberek számát.
*	**Kamerahasználat**: A felhasnzálónak lehetősége van a feltöltésből a fényképező alkalmazást indítani és azzal képeket csinálni az ingatlanról.
