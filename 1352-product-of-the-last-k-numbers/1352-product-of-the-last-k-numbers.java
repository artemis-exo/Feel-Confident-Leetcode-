class ProductOfNumbers {
    List<Integer> li;
    public ProductOfNumbers() {
        li=new ArrayList<>();
        li.add(1); // for product because 1 se multiply krne pr number itself ata hai or 0 based indexing to mathc krne ke liye bhi
    }
    
    public void add(int num) {
      if(num==0){
        li.clear();
        li.add(1);

      }
      else{
        li.add(li.get(li.size()-1)*num);
      }
    }
    
    public int getProduct(int k) {
        if(k>=li.size()){
            return 0;
        }
        return li.get(li.size()-1)/li.get(li.size()-1-k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */