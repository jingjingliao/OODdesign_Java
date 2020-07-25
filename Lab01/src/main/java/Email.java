/**
 * Represents an Email with their details--login name and domain name *
 * @author jingjing
 *
 */
public class Email {
    private String loginName;
    private String domainName;

    /**
     * @param loginName the emails's login name
     * @param domainName the emails's domain name
     */
    public Email(String loginName, String domainName){
        this.loginName = loginName;
        this.domainName = domainName;
    }

    /**
     * @return the login name
     */
    public String getLoginName(){
        return this.loginName;
    }

    /**
     * @return the domain name
     */
    public String getDomainName(){
        return this.domainName;
    }
}
