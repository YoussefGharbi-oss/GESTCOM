import java.util.Scanner;
import java.util.Vector;

abstract class Personne{
    //declaration des variable
    protected int ident;

    protected String nomSocial;
    protected String adresse;
    //parametrized constructor
    protected Personne(int ident, String nomSocial, String adresse) {
        this.ident = ident;
        this.nomSocial = nomSocial;
        this.adresse = adresse;

    }
    //getters of every attribut

    public int getIdent() {
        return this.ident;

    }

    public String getNomSocial() {
        return this.nomSocial;

    }

    protected String getAdresse() {
        return this.adresse;

    }
    //setter of every attributs
    public void setIdent(int ident) {
        this.ident = ident;

    }

    public void setNomSocial(String nomSocial) {
        this.nomSocial = nomSocial;

    }

    protected void setAdresse(String adresse) {
        this.adresse = adresse;

    }
    public void affiche(){
        System.out.println("Identifiant : "+this.ident + " " + "Nom social : "+this.nomSocial + " " + "Adresse : "+this.adresse);


    }
}
//client class (sub class) of Person
class Client extends Personne{
    //Declarations des vatiables
    private double chiffreaffaire;
    public Client(int ident ,String nomSocial , String adresse , double chiffreaffaire){
        super(ident,nomSocial,adresse) ;
        this.chiffreaffaire = chiffreaffaire ;
    }
    public double getChiffreaffaire(){
        return this.chiffreaffaire ;
    }
    public void setChiffreaffaire(double chiffreaffaire){
        this.chiffreaffaire = chiffreaffaire ;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("chiffre d 'affaire :" + chiffreaffaire);

    }
}
//Class Aricle
class Article{
    //Declarations of Variable
    private int reference ;
    private String designation ;
    private double prixunitaire ;
    private int quantiteStock ;
    //parametrized constructor
    public Article(int reference , String designation , double prixunitaire , int quantiteStock){
        this.reference = reference ;
        this.designation = designation ;
        this.prixunitaire = prixunitaire ;
        this.quantiteStock = quantiteStock ;
    }
    //constructor with copy
    public Article(Article article){
        this.reference = article.reference ;
        this.designation = article.designation ;
        this.prixunitaire = article.prixunitaire ;
        this.quantiteStock = article.quantiteStock ;

    }
    //getters and setters of every attributs
    public int getReference(){
        return this.reference ;
    }
    public String getDesignation(){
        return this.designation ;
    }
    public double getPrixunitaire(){
        return this.prixunitaire ;
    }
    public int getQuantiteStock(){
        return this.quantiteStock ;
    }
    public void setReference(int reference){
        this.reference = reference ;
    }
    public void setDesignation(String designation){
        this.designation = designation ;
    }
    public void setPrixunitaire(double prixunitaire){
        this.prixunitaire = prixunitaire ;
    }
    public void setQuantiteStock(int quantiteStock){
        this.quantiteStock = quantiteStock ;
    }
    //Affiche Method
    public void affiche(){
        System.out.println("Reference : "+this.reference + " " + "Designation : "+this.designation + " " + "Prix unitaire : "+this.prixunitaire + " " + "Quantite en stock : "+this.quantiteStock);
    }


}
//class commande
class Commande{
    private int numcom ;
    private String datecom ;
    private Client client ;
    //constructor
    public Commande(int numcom , String datecom , Client client){
        this.numcom = numcom ;
        this.datecom = datecom ;
        this.client = client ;
    }
    //getters and setters
    public int getNumcom(){
        return this.numcom ;
    }
    public String getDatecom(){
        return this.datecom ;
    }
    public Client getClient(){
        return this.client ;
    }
    public void setNumcom(int numcom){
        this.numcom = numcom ;
    }
    public void setDatecom(String datecom){
        this.datecom = datecom ;
    }
    public void setClient(Client client){
        this.client = client ;
    }
}
class Ligne{
    private  Commande commande ;
    private Article article ;
    private int quantiteCOm ;
    //constructor
    public Ligne(Commande commande , Article article , int quantiteCOm){
        this.commande = commande ;
        this.article = article ;
        this.quantiteCOm = quantiteCOm ;
    }

    //getters and setters
    public Commande getCommande(){
        return this.commande ;
    }
    public Article getArticle(){
        return this.article ;
    }
    public int getQuantiteCOm(){
        return this.quantiteCOm ;
    }
    public void setCommande(Commande commande){
        this.commande = commande ;
    }
    public void setArticle(Article article){
        this.article = article ;
    }
    public void setQuantiteCOm(int quantiteCOm){
        this.quantiteCOm = quantiteCOm ;
    }

}
public class commerciale {
    Vector<Client> clients = new Vector<Client>();
    Vector<Commande> commandes = new Vector<Commande>();
    Vector<Article> articles = new Vector<Article>();
    Vector<Ligne> lignes = new Vector<Ligne>();
    public void PasserCommande(Commande commande){
        commandes.add(commande);
    }
    public void Annulercommande(Commande c){
        commandes.remove(c);
    }
    public void AjouterArticle(Article article){
        articles.add(article);

    }
    public void SupprimerArticle(Article article){
        articles.remove(article);
    }
    public void AjouterClient(Client client){
        clients.add(client);
    }
    public void SupprimerClient(Client client){
        clients.remove(client);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




        commerciale c = new commerciale();
        //add articles to test
        Article a1 = new Article(1,"Article1",10,10);
        Article a2 = new Article(2,"Article2",20,20);
        Article a3 = new Article(3,"Article3",30,30);
        Article a4 = new Article(4,"Article4",40,40);
        c.AjouterArticle(a1);
        c.AjouterArticle(a2);
        c.AjouterArticle(a3);
        c.AjouterArticle(a4);
        //Add client to test
        Client cl1 = new Client(1,"Client1","Adresse1",100);
        Client cl2 = new Client(2,"Client2","Adresse2",200);
        Client cl3 = new Client(3,"Client3","Adresse3",300);
        Client cl4 = new Client(4,"Client4","Adresse4",400);
        c.AjouterClient(cl1);
        c.AjouterClient(cl2);
        c.AjouterClient(cl3);
        c.AjouterClient(cl4);
        //Add commande to test
        Commande com1 = new Commande(1,"Date1",cl1);
        Commande com2 = new Commande(2,"Date2",cl2);
        Commande com3 = new Commande(3,"Date3",cl3);
        Commande com4 = new Commande(4,"Date4",cl4);
        //parcours the Article Vector

        int choix = -1;

        while(choix !=0 ){
            System.out.println("--------------------");
            System.out.println("1- Ajouter un article");
            System.out.println("2- Supprimer une commande");
            System.out.println("3- Ajouter  un client");
            System.out.println("4- supprimer un client");
            System.out.println("5- Afficher Passer une commande ");
            System.out.println("6-  Annuler une commande");
            System.out.println("0- Quitter");
            System.out.println("--------------------");
            System.out.println("Votre choix : ");
            choix = sc.nextInt();
            //based on user Choice we perform the commands

            switch (choix) {
                case 1:
                    System.out.println("Reference : ");
                    int reference = sc.nextInt();
                    System.out.println("Designation : ");
                    String designation = sc.next();
                    System.out.println("Prix unitaire : ");
                    double prixunitaire = sc.nextDouble();
                    System.out.println("Quantite en stock : ");
                    int quantiteStock = sc.nextInt();
                    Article a = new Article(reference, designation, prixunitaire, quantiteStock);
                    c.AjouterArticle(a);
                    break;
                case 2:
                    System.out.println("Articles Before Suppression ");

                    for (int i = 0; i < c.articles.size(); i++) {
                        c.articles.get(i).affiche();
                    }
                    System.out.println("Enter the reference of the article you want to delete");

                    int ref = sc.nextInt();
                    for (int i = 0; i < c.articles.size(); i++) {
                        if (c.articles.get(i).getReference() == ref) {
                            c.SupprimerArticle(c.articles.get(i));
                        }
                    }
                    System.out.println("Articles After Suppression ");
                    for (int i = 0; i < c.articles.size(); i++) {
                        c.articles.get(i).affiche();
                    }
                    break;
                case 3:
                    System.out.println("Identifiant : ");
                    int ident = sc.nextInt();
                    System.out.println("Nom social : ");
                    String nomSocial = sc.next();
                    System.out.println("Adresse : ");
                    String adresse = sc.next();
                    System.out.println("Chiffre d'affaire : ");
                    double chiffreaffaire = sc.nextDouble();
                    Client cl = new Client(ident, nomSocial, adresse, chiffreaffaire);
                    c.AjouterClient(cl);
                    break;
                case 4:
                    System.out.println("Clients Before Suppression ");
                    for (int i = 0; i < c.clients.size(); i++) {
                        c.clients.get(i).affiche();
                    }
                    System.out.println("Enter the identifiant of the client you want to delete");
                    int id = sc.nextInt();
                    for (int i = 0; i < c.clients.size(); i++) {
                        if (c.clients.get(i).getIdent() == id) {
                            c.SupprimerClient(c.clients.get(i));
                        }
                    }
                    System.out.println("Clients After Suppression ");
                    for (int i = 0; i < c.clients.size(); i++) {
                        c.clients.get(i).affiche();
                    }
                    break;
                case 5:
                    System.out.println("Enter the reference of the article you want to add to the commande");
                    int ref1 = sc.nextInt();
                    System.out.println("Enter the identifiant of the client you want to add to the commande");
                    int id1 = sc.nextInt();
                    System.out.println("Enter the number of the commande");
                    int numcom = sc.nextInt();
                    System.out.println("Enter the date of the commande");
                    String datecom = sc.next();
                    for (int i = 0; i < c.articles.size(); i++) {
                        if (c.articles.get(i).getReference() == ref1) {
                            for (int j = 0; j < c.clients.size(); j++) {
                                if (c.clients.get(j).getIdent() == id1) {
                                    Commande com = new Commande(numcom, datecom, c.clients.get(j));
                                    Ligne l = new Ligne(com, c.articles.get(i), 1);
                                    c.lignes.add(l);
                                }
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter the number of the commande you want to delete");
                    int numcom1 = sc.nextInt();
                    for (int i = 0; i < c.lignes.size(); i++) {
                        if (c.lignes.get(i).getCommande().getNumcom() == numcom1) {
                            c.lignes.remove(c.lignes.get(i));
                        }
                    }
                    break;
                case 0:
                    System.out.println("Good Bye");
                    break;

            }








        }






    }
}
