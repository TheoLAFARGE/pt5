
import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;


public class Client {

    public static void main(String...args) {
        Config noSSL = Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig();
           Driver driver = GraphDatabase.driver("bolt://localhost:7687",AuthTokens.basic("neo4j","root"),noSSL); // <password>
        String login = "neo4j";
        String password = "root";
       //Driver driver = driver("bolt://localhost:7687",AuthTokens.basic(login,password)); // <password>
        try (Session session = driver.session()) {
            StatementResult result;
            String foafQuery =
                    " MATCH (c:Client) return c limit 10 ";
            result = session.run(foafQuery);
            while (result.hasNext()) System.out.println(result.next());
        }
    }
};