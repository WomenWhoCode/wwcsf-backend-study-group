package coding.problems;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/* PagerDuty onsite interview question 2019
 * Parse JSON from PagerDuty API: https://v2.developer.pagerduty.com/
 * API:
   curl -G -H "Authorization: Token token=y_NbAkKc66ryYTWUXYEu" \
  -H "Accept: application/vnd.pagerduty+json;version=2" \
  --data-urlencode "statuses[]=triggered" \
  --data-urlencode "statuses[]=acknowledged" \
  "https://api.pagerduty.com/incidents"

   Output:
   {"incidents":[],"limit":25,"offset":0,"total":null,"more":false}
 *
 * https://dzone.com/articles/how-to-parse-json-data-from-a-rest-api-using-simpl
 // get the URL -> API
 // Set headers -> Authorization, Accept
 // http url connection
 // set the http method -> GET
 // open connection, get input stream
 // parse json -> object, get(key)
 // Names of all users, specify one name of one user -> get contact details
 */
public class JsonParseUrl {

    public static void main(String[] args) throws IOException, ParseException {
        JsonParseUrl jsonParseUrl = new JsonParseUrl();
        jsonParseUrl.getAddressBook("https://api.pagerduty.com/users");
    }

    public void getAddressBook(String url) throws IOException, ParseException {
        URL getUsersUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) getUsersUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.addRequestProperty("Accept", "application/vnd.pagerduty+json;version=2");
        connection.addRequestProperty("Authorization", "Token token=y_NbAkKc66ryYTWUXYEu");

        connection.connect();

        // status code, message
        // stream -> string -> parse in into json object
        StringBuilder sb = new StringBuilder(); // Response body
        Scanner sc = new Scanner(connection.getInputStream());
        while (sc.hasNext()) {
            sb.append(sc.next());
        }

        String responseBody = sb.toString();    // String -> Response Body

        JSONParser parser = new JSONParser();
        JSONObject responseObject = (JSONObject) parser.parse(responseBody);    // Json
        JSONArray arrayOfUsers = (JSONArray) responseObject.get("users");   // all users [array]
        System.out.println(arrayOfUsers);

        for (JSONObject user : (Iterable<JSONObject>) arrayOfUsers) {
            String userName = (String) user.get("name");
            System.out.println(userName);
        }
    }
}

// Return names of users only:
/*
AbagailHickle
AdalbertoRyan
AdelinePfeffer
AgustinaBeatty
AidenHuel
AishaWeissnat
AlbertKlein
AlberthaHowe
AlbinaEmmerich
AlbinaWilliamson
AlessandroCrona
AlexandraVandervort
AlfRowe
AliceO'Connell
AllyLuettgen
AlyceTurcotte
AmayaKovacek
AmbroseMaggio
AnahiDooley
AnneSchimmel
AntwanHane
AnyaFeil
ArdenGusikowski
ArielKuhlman
ArleneKautzer
 */
