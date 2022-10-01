#include<bits/stdc++.h>
using namespace std;

bool perfect(string s){
    int n = s.size();
    vector<int> a(26,0),b(26,0);
    int x = n/2+n%2;
    for(int i=0;i<n/2;i++){
        a[s[i]-'a']++;
        b[s[i+x]-'a']++; 
    }
    if(n%2 == 0){
        // for(int i=0;i<26;i++){
        //     if(a[i] != b[i]) return false;
        // }
        return false;;
    }
    if(n%2==1){
        bool is = true;
        for(int i=0;i<26;i++){
            if(a[i] != b[i]){
                is =false;
                break;
            }
        }
        if(is) return is;
        a[s[n/2]-'a']++;
        int z = 0;
        for(int i=0;i<26;i++){
            if(a[i] != b[i]){
                z += abs(a[i]-b[i]);
            }
        }
        if(z == 1) return true;
        a[s[n/2]-'a']--;
        b[s[n/2]-'a']++;
        z = 0;
        for(int i=0;i<26;i++){
            if(a[i] != b[i]){
                z += abs(a[i]-b[i]);
            }
        }
        if(z == 1) return true;
    }
    return false;

}

int main(){
    freopen("input.txt", "r" , stdin);
    freopen("output.txt", "w", stdout);
    int t;
    cin>>t;
    string s;
    int z = 1;
    while(t--){
        cin>>s;
        int q;
        cin>>q;
        vector<vector<int>> p(q,vector<int>(2,0));    
        int x,y;
        for(int i=0;i<q;i++){
            cin>>x;
            cin>>y;
            p[i][0] = x;
            p[i][1] = y;
        }    
        // cout<<p[1][0]<<" "<<p[1][1]<<endl;
        // cout<<s.substr(p[1][0]-1,p[1][1] - p[1][0]+1)<<endl;
        int count = 0;
        for(int i=0;i<q;i++){
            if(perfect(s.substr(p[i][0]-1,p[i][1] - p[i][0]+1))){
                count++;
            }
        }
        cout<<"Case #"<<z<<": "<<count<<endl;
        z++;
        // for(int i=0;i<q;i++){
        //     cout<<s.substr(p[i][0]-1,p[i][1] - p[i][0]+1)<<endl;
        // }
        // cout<<endl;
    }

}
