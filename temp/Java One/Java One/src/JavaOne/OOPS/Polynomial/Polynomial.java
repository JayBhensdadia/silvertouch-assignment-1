package JavaOne.OOPS.Polynomial;

import JavaOne.OOPS.DynamicArrays.DynamicArray;

public class Polynomial {
    
    DynamicArray coefficients;

    public Polynomial(){
        coefficients = new DynamicArray();

    }

    public void setCoefficient(int deg, int coeff){
        //System.out.println("inside setcoff method");
        if(deg>=this.degree()){

            //System.out.println("deg >= this.degree()");
            //int n = deg - this.degree() + 1;
            for (int i = this.degree(); i <= deg; i++) {
                coefficients.add(0);
            }
        }
        //System.out.println("dhoom");
        coefficients.set(deg, coeff);        
    }

    public int getCoeeficient(int deg){
        int temp = coefficients.get(deg);
        return temp;
    }

    public int degree(){
        return coefficients.size();
    }

    public void print(){
        for(int i = 0; i < coefficients.size(); i++){
            if(coefficients.get(i)!=0){
                System.out.print(coefficients.get(i)+"x"+"^"+i+" + ");
            }
        }
        System.out.println();
    }

    public void add(Polynomial p){
        for(int i = 0; i < p.degree(); i++){
            if(p.getCoeeficient(i)!=0 && this.getCoeeficient(i)!=0){
                this.setCoefficient(i, this.getCoeeficient(i)+p.getCoeeficient(i));
            }
        }
    }

    public void subtract(Polynomial p){

        for(int i = 0; i < p.degree(); i++){
            if(p.getCoeeficient(i)!=0 && this.getCoeeficient(i)!=0){
                this.setCoefficient(i, this.getCoeeficient(i)-p.getCoeeficient(i));
            }
        }

    }

    public void multiply(Polynomial p){

        int loopI = 0;
        int loopJ = 0;
        for(int i = 0; i < p.degree(); i++){

            int finalCoff = 0;

            //System.out.println(p.getCoeeficient(i));
            if(p.getCoeeficient(i)!=0){

                for(int j = 0; j < this.degree(); j++){

                    //System.out.println(this.getCoeeficient(j));
                    if(this.getCoeeficient(j)!=0){

                        int deg = i+j;
                        int coff = (p.getCoeeficient(i) * this.getCoeeficient(j));
                        System.out.println("coff = " + coff);
                        System.out.println("coff of degree  "+deg+" is "+this.getCoeeficient(deg));
                        
                        finalCoff = coff;
                        System.out.println("final coff of degree "+i+" is "+finalCoff);

                        int prevCoff = this.getCoeeficient(deg);

                        // if(prevCoff == -1){
                        //     //this.setCoefficient(deg,coff);
                        //     finalCoff = coff;
                        //     continue;
                        // }else{
                        //     //this.setCoefficient(deg, coff + prevCoff);
                        //     finalCoff = coff + prevCoff;
                        //     continue;
                        // }
                        
                        
                        // System.out.println("before calling setCoff method");
                        // this.setCoefficient(deg,coff);
                        // System.out.println("after calling setcoff method");
                        
                        

                    }
                
                   loopJ++;
                    
                }

            }
            
            loopI++;
            
        }

        System.out.println("loop i = "+loopI);
        System.out.println("loop j = "+loopJ);

    }



}
