class MemoryLeakDector{
   private static int  total_memory;
   MemoryLeakDector(int total_memory){
    this.total_memory=total_memory;
   }
   public void aloocate(int Memory){
    total_memory+=Memory;
   }
   public void free(int Memory){
    total_memory-=Memory;
   }
   public int show(){
    return total_memory;
   }
}