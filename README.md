# Stardew Valley API
This is a WIP project attempting to make a web API for the game Stardew Valley.  The goal is to aid in the sharing of information about the game, and create a unified source that various projects can use.  Some examples:
- Other Web Applications
- Mobile Applications
- Chat bots

Right now the project is a bit unstructured, and only the crop endpoint has been created.  Eventually I will have documentation setup for the various endpoints.  This was really just a way to play around with Kotlin and SpringBoot.

## Client
There is a client folder which contains the DTOs and eventually `HttpClient` code for accessing the API through other Java/JVM projects.  These are the same DTOs that are used by the server application to serialize the information into JSON.

## Seeding
Data is seeded from the `.tsv` files stored in the `resources/data` folder.  The seeding is done via the seeders found in the `net.smcrow.stardewapi.seeding` package.  

To keep things as simple as possible I'm currently using an in-memory database.  The database is seeded during the booting process of the application.  

I chose to keep the values in `.tsv` because I found it was easier to maintain the list and update all the data at once.  Additionally, the data is relatively unmutable and can be updated manually as part of the release process.

I believe that by doing this on booting of the application any performance from seeding is negligible. 
## Example
Here's an example from the crop endpoint which offers the following features:
- `https://stardewapi.herokuapp.com/` - Display a list of crops.
- `https://stardewapi.herokuapp.com/{id}` - Display a crop by `{id}`.
- `https://stardewapi.herokuapp.com/crops/search?name={name}` - Display a list of crops with a name matching `{name}`
- `https://stardewapi.herokuapp.com/crops/giant` - Display a list of crops that can grow giant if placed in a grid.

### Response
Here's the response object for a single crop:
```json
{
  "status": "success",
  "data": {
    "crop": {
      "id": 2,
      "name": "Cauliflower",
      "description": "Valuable, but slow-growing. Despite its pale color, the florets are packed with nutrients.",
      "harvest": {
        "initialTime": 12,
        "recurringTime": 0
      },
      "sellingPrice": {
        "base": 175,
        "silver": 218,
        "gold": 262
      },
      "canBeGiant": true,
      "prices": [
        {
          "store": "Pierre's General Store",
          "price": 80
        },
        {
          "store": "JojaMart",
          "price": 100
        }
      ]
    }
  }
}
```
The API will attempt to maintain [JSend Compliant Responses](https://labs.omniti.com/labs/jsend)