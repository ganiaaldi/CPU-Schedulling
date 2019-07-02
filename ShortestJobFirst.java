import java.util.Scanner;
 
class SO3_GaniaAldi_SJF {
public static void main(String args[]){
int process[],burst_time[],waiting_time[],tat[],i,j,n,total=0,pos,temp;
float wait_avg,TAT_avg;
Scanner s = new Scanner(System.in);
 
System.out.print("Masukan Jumlah proses : ");
n = s.nextInt();
 
process = new int[n];
burst_time = new int[n];
waiting_time = new int[n];
tat = new int[n];
 
System.out.println("\nMasukan Burst Time:");
for(i=0;i<n;i++)
{
System.out.print("\nProses["+(i+1)+"]: ");
burst_time[i] = s.nextInt();;
process[i]=i+1; //Process Number
}
 

for(i=0;i<n;i++)
{
pos=i;
for(j=i+1;j<n;j++)
{
if(burst_time[j]<burst_time[pos])
pos=j;
}
 
temp=burst_time[i];
burst_time[i]=burst_time[pos];
burst_time[pos]=temp;
 
temp=process[i];
process[i]=process[pos];
process[pos]=temp;
}

waiting_time[0]=0;

for(i=1;i<n;i++)
{
waiting_time[i]=0;
for(j=0;j<i;j++)
waiting_time[i]+=burst_time[j];
 
total+=waiting_time[i];
}

wait_avg=(float)total/n;
total=0;
 
System.out.println("\nProses\t Burst Time \tWaiting Time\tTurnaround Time");
for(i=0;i<n;i++)
{
tat[i]=burst_time[i]+waiting_time[i]; 
total+=tat[i];
System.out.println("\n P"+process[i]+"\t\t\t "+burst_time[i]+"\t\t\t\t "+waiting_time[i]+"\t\t\t \t"+tat[i]);
}
 
TAT_avg=(float)total/n;
System.out.println("\n\nAverage Waiting Time: "+wait_avg);
System.out.println("\nAverage Turnaround Time: "+TAT_avg);
 
}}