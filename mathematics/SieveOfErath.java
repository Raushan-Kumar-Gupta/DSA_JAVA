import java.util.*;
public class SieveOfErath {
    public static void main(String[] args) {
        int n =10;
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2; i*i<=n ; i++){
            if(prime[i]){
                for(int j = i*i; j<=n; j+=i){
                    prime[j]=false;
                }
            }
        }
        for(int i=0; i<=n; i++){
            if(prime[i]){
                System.out.print(i+" ");
            }
        }
    }
}
