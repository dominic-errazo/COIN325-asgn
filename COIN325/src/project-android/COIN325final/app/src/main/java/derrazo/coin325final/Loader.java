/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package derrazo.coin325final;

import java.util.Set;

/**
 *
 * @author Dominic
 */
public interface Loader {
    
    public Set<String> getCheeses();
    public Set<String> getCheeses(String tag);
    public Set<String> getTags();
    public Set<String> getTags(String cheese);
    public Cheese getCheese(String cheeseName);
    
}
