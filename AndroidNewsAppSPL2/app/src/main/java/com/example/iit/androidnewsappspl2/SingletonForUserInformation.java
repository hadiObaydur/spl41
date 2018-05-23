package com.example.iit.androidnewsappspl2;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SingletonForUserInformation
{
    private static SingletonForUserInformation singletonForUserInformation;
    ArrayList<String>allCategories=new ArrayList<String>(Arrays.asList("business","entertainment","health","science","sports","technology"));
    ArrayList<String>userCategory=new ArrayList<String>(Arrays.asList("top-sources","top-stories","for you"));

    ArrayList<String>languageName=new ArrayList<String>(Arrays.asList("Argentina", "Australia", "Austria","Belgium","Brazil","Bulgaria","Canada","China","Colombia","Cuba","Czech Republic","Egypt","France","Germany","Greece","Hong Kong","Hungary","India","Indonesia","Ireland","Israel","Italy","Japan","Latvia","Lithunia","Malaysia","Mexico","Morocco","Netherlands","New Zealand","nigeria","Norway","Philippines","Poland","Portugal","Romania","Russia","Saudi Arabia","Serbia","Singapore","Slovakia","Slovenia","South Africa","South Korea","Sweden","Switzerland","Taiwan","Thailand","Turkey","UAE","Ukraine","United Kingdom","United States","Venujuela"));
    ArrayList<String>languageShortName=new ArrayList<String>(Arrays.asList("ar","au","at","be","br","bg","ca","cn","co","cu","cz","eg","fr","de","gr","hk","hu","in","id","ie","il","it","jp","lv","lt","my","mx","ma","nl","nz","ng","no","ph","pl","pt","ro","ru","sa","rs","sg","sk","si","za","kr","se","ch","tw","th","tr","ae","ua","gb","us","ve"));
    ArrayList<String>allSources=new ArrayList<String>(Arrays.asList("ABC News","ABC News (AU)","Aftenposten","Al Jazeera English","ANSA.it","Argaam","Ars Technica", "Ary News", "Associated Press", "Australian Financial Review", "Axios", "BBC News", "BBC Sport", "Bild", "Blasting News (BR)", "Bleacher Report", "Bloomberg" ,"Breitbart News", "Business Insider", "Business Insider (UK)", "Buzzfeed", "CBC News", "CBS News", "CNBC", "CNN", "CNN Spanish", "Crypto Coins News" ,"Daily Mail", "Der Tagesspiegel", "Die Zeit","El Mundo","Engadget","Entertainment Weekly","ESPN","ESPN Cric Info","Financial Post","Financial Times","Focus" ,"Football Italia","Fortune" ,"FourFourTwo","Fox News","Fox Sports","Globo","Google News","Google News (Argentina)","Google News (Australia)",    "Google News (Brasil)" ,"Google News (Canada)" ,"Google News (France)" ,"Google News (India)" ,"Google News (Israel)", "Google News (Italy)","Google News (Russia)","Google News (Saudi Arabia)","Google News (UK)" ,"Göteborgs-Posten","Gruenderszene" ,"Hacker News","Handelsblatt","IGN" ,"Il Sole 24 Ore","Independent","Infobae","InfoMoney","La Gaceta","La Nacion","La Repubblica","Le Monde" ,"Lenta" ,"L'equipe","Les Echos","Libération","Marca","Mashable","Medical News Today","Metro","Mirror","MSNBC", "MTV News" ,"MTV News (UK)","National Geographic" ,"National Review","NBC News" ,"News24","New Scientist","News.com.au" ,"Newsweek","New York Magazine","Next Big Future","NFL News","NHL News","NRK","Politico","Polygon","RBC","Recode","Reddit/r/all","Reuters","RT","RTE","RTL Nieuws","SABQ","Spiegel Online","Svenska Dagbladet" ,"T3n","TalkSport" ,"TechCrunch","TechCrunch (CN)","TechRadar","The American Conservative","The Economist","The Globe And Mail","The Guardian (AU)","The Guardian (UK)" ,"The Hill","The Hindu","The Huffington Post","The Irish Times" ,"The Lad Bible","The New York Times","The Next Web","The Sport Bible","The Telegraph","The Times of India","The Verge","The Wall Street Journal","The Washington Post","The Washington Times","Time","USA Today","Vice News","Wired","Wired.de","Wirtschafts Woche","Xinhua Net","Ynet"));
    ArrayList<String>allSourcesRealName=new ArrayList<String>(Arrays.asList("abc-news", "abc-news-au", "aftenposten", "al-jazeera-english", "ansa", "argaam", "ars-technica", "ary-news", "associated-press", "australian-financial-review", "axios", "bbc-news", "bbc-sport", "bild", "blasting-news-br", "bleacher-report", "bloomberg", "breitbart-news", "business-insider", "business-insider-uk", "buzzfeed", "cbc-news", "cbs-news", "cnbc", "cnn", "cnn-es", "crypto-coins-news", "daily-mail", "der-tagesspiegel", "die-zeit", "el-mundo", "engadget", "entertainment-weekly", "espn", "espn-cric-info", "financial-post", "financial-times", "focus", "football-italia", "fortune", "fourfourtwo", "fox-news", "fox-sports", "globo", "google-news", "google-news-ar", "google-news-au", "google-news-br", "google-news-ca", "google-news-fr", "google-news-in", "google-news-is", "google-news-it", "google-news-ru", "google-news-sa", "google-news-uk", "göteborgs-posten", "gruenderszene", "hacker-news", "handelsblatt", "ign", "il-sole-24-ore", "independent", "infobae", "info-money", "la-gaceta", "la-nacion", "la-repubblica", "le-monde", "lenta", "lequipe", "les-echos", "liberation", "marca", "mashable", "medical-news-today", "metro", "mirror", "msnbc", "mtv-news", "mtv-news-uk", "national-geographic", "national-review", "nbc-news", "news24", "new-scientist", "news-com-au", "newsweek", "new-york-magazine", "next-big-future", "nfl-news", "nhl-news", "nrk", "politico", "polygon", "rbc", "recode", "reddit-r-all", "reuters", "rt", "rte", "rtl-nieuws", "sabq", "spiegel-online", "svenska-dagbladet", "t3n", "talksport", "techcrunch", "techcrunch-cn", "techradar", "the-american-conservative", "the-economist", "the-globe-and-mail", "the-guardian-au", "the-guardian-uk", "the-hill", "the-hindu", "the-huffington-post", "the-irish-times", "the-lad-bible", "the-new-york-times", "the-next-web", "the-sport-bible", "the-telegraph", "the-times-of-india", "the-verge", "the-wall-street-journal", "the-washington-post", "the-washington-times", "time", "usa-today", "vice-news", "wired", "wired-de", "wirtschafts-woche", "xinhua-net", "ynet"));
    ArrayList<String>allSourcesCategories=new ArrayList<String>(Arrays.asList("general", "general", "general", "general", "general", "business", "technology", "general", "general", "business", "general", "general", "sports", "general", "general", "sports", "business", "general", "business", "business", "entertainment", "general", "general", "business", "general", "general", "technology", "entertainment", "general", "business", "general", "technology", "entertainment", "sports", "sports", "business",  "business", "general", "sports", "business", "sports", "general", "sports", "general", "general","general","general", "general","general","general","general","general", "general","general","general","general","general", "technology", "technology", "business", "entertainment", "business","general","general" ,"business", "general","general","general","general","general", "sports", "business", "general", "sports", "entertainment", "health", "general","general","general", "entertaiment", "entertainment", "science", "general","general","general", "science", "general","general","general", "science", "sports", "sports", "general","general","entertainment", "general", "technology", "general","general","general","general","general","general","general","general", "technology", "sports", "technology", "technology", "technology","general","business","general","general","general","general","general","general","general", "entertainment", "general", "technology", "sports", "general", "general", "technology", "business", "general","general","general","general","general", "technology", "technology", "business", "general","general"));

    ArrayList<String>preferSources=new ArrayList<String>();
    ArrayList<String>preferSourcesCategories=new ArrayList<String>();
    ArrayList<String>preferSourcesForAdapter=new ArrayList<String>();
    ArrayList<String>blockSources=new ArrayList<String>();
    ArrayList<String>blockSourcesForAdapter=new ArrayList<String>();
    String selectedLanguage="us";

    private SingletonForUserInformation()
    {

    }

    public static SingletonForUserInformation getSingletonForUserInformation()
    {
        if (singletonForUserInformation == null) {
            synchronized(SingletonForUserInformation.class)
            {
                if (singletonForUserInformation == null)
                {

                    singletonForUserInformation = new SingletonForUserInformation();
                }
            }
        }

        return singletonForUserInformation;
    }

    public ArrayList<String> getAllCategories() {
        return allCategories;
    }

    public ArrayList<String> getUserCategory() {
        return userCategory;
    }

    public int getCountOfUserCategory(){
        return userCategory.size()-3;
    }

    public void addCategoryForUser(String addCategoryName)
    {
        userCategory.add(addCategoryName);

    }

    public void deleteCategoryForUser(String deleteCategoryName)
    {
              userCategory.remove(deleteCategoryName);
    }

    public ArrayList<String> getAllLanguageName() {
        return languageName;
    }

    public void addSelectedLanguage(String selectedLanguage){
        if(!languageName.contains(selectedLanguage)){}
        else {
            int languagePosition = languageName.indexOf(selectedLanguage);
            this.selectedLanguage = languageShortName.get(languagePosition);
        }
    }

    public String getSelectedLanguage(){
        return selectedLanguage;
    }

    public ArrayList<String> getAllSources() {
        return allSources;
    }

    public void addPreferSources(String preferSourceName){
        int preferSourcePosition=allSources.indexOf(preferSourceName);
        preferSources.add(allSourcesRealName.get(preferSourcePosition));
        preferSourcesForAdapter.add(allSources.get(preferSourcePosition));
        preferSourcesCategories.add(allSourcesCategories.get(preferSourcePosition));

    }

    public void deletePreferSources(String deletePreferSourceName){
        int deletePreferSourcePosition=allSources.indexOf(deletePreferSourceName);
        preferSources.remove(allSourcesRealName.get(deletePreferSourcePosition));
        preferSourcesForAdapter.remove(allSources.get(deletePreferSourcePosition));
        preferSourcesCategories.remove(allSourcesCategories.get(deletePreferSourcePosition));

    }
    public ArrayList<String> getPreferSources() {
        return preferSources;
    }

    public ArrayList<String> getPreferSourcesForAdapter() {
        return preferSourcesForAdapter;
    }

    public ArrayList<String> getPreferSourcesCategories() {
        return preferSourcesCategories;
    }

    public void addBlockSources(String blockSourceName){
        int blockSourcePosition=allSources.indexOf(blockSourceName);
        blockSources.add(allSourcesRealName.get(blockSourcePosition));
        blockSourcesForAdapter.add(blockSourceName);

    }

    public void unBlockSources(String unBlockSourceName){
        int unBlockSourcePosition=allSources.indexOf(unBlockSourceName);
        blockSources.remove(allSourcesRealName.get(unBlockSourcePosition));
        blockSourcesForAdapter.remove(unBlockSourceName);

    }
    public ArrayList<String> getBlockSources() {
        return blockSources;
    }

    public ArrayList<String> getBlockSourcesForAdapter() {
        return blockSourcesForAdapter;
    }
}