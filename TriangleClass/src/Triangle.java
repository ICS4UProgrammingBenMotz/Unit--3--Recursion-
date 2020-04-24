public class Triangle {
    private int side1;
    private int side2;
    private int side3;
    public double Area;
    public int perimeter;
    public int base;
    public int notbase1;
    public int notbase2;
    public String Type;

    //creates constructor
    public void Triangle (int Oside1, int Oside2, int Oside3) {

        //sets variables
        side1 = Oside1;
        side2 = Oside2;
        side3 = Oside3;
        perimeter = side1 + side2 + side3;

        //gets the longest side, which will be used to calculate certain values
        if (side1>side2 && side1 > side3) {
            base = side1;
            notbase1=side2;
            notbase2=side3;
        } else if (side2>side1 && side2 > side3){
            base = side2;
            notbase1=side1;
            notbase2=side3;
        } else if (side3>side1 && side3 > side1){
            base = side3;
            notbase1=side1;
            notbase2=side2;
        }
        else{
            base=1;
            notbase2=1;
            notbase1=1;
        }
    }
    //calcs the triangles area
    public double calcArea(){
        //create a semiperimeter
        double s = perimeter/2;

        Area = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));

        Area = Math.round(Area * 100.00) / 100.00;

        return Area;
    }

    //checks if the triangle is valid
    protected boolean isTriValid(){
        boolean isvalid;
        //if these are true then the triangle is valid
        if (side1+side2>side3 && side1+side3>side2 && side2+side3>side1){
            isvalid=true;
        }
        else{
            isvalid=false;
        }
        return isvalid;
    }

    public double AreaOfCircumcircle(){
        //calcs the area of the triangle's circumcircle
        int a = side1*side2*side3;

        double AreaCirc = a/Math.sqrt((side1+side2+side3)*(side2+side3-side1)*(side3+side1-side2)*(side1+side2-side3));

        //rounds the value to 2 decimal places
        AreaCirc = Math.round(AreaCirc * 100.00) / 100.00;
        return AreaCirc;
    }

    public double calcHeight(){
        double Height = (2*Area)/base;

        Height = Math.round(Height * 100.00) / 100.00;

        return Height;
    }

    public String TriangleType(){
        //determines the type of triangle
        if (side1==side2 || side1==side3 || side2==side3){
            if (side1==side2 && side1==side3 && side2==side3){
                Type="Equalateral";
            }
            else{
                Type="Isosceles";
            }
        }
        else if(base==Math.sqrt(notbase1*notbase1 + notbase2*notbase2)){
            Type="Right";
        }
        else if(base<Math.sqrt(notbase1*notbase1 + notbase2*notbase2)){
            Type="Acute";
        }
        else if (base>Math.sqrt(notbase1*notbase1 + notbase2*notbase2)){
            Type="Obtuse";
        }
        else{
            Type="This triangle does not exist";
        }
        return Type;
    }

    public double radOFInscCirc(){
        //calcs the radius of the largest inscribed circle
        double rad = Area/(perimeter/2);
        rad = Math.round(rad * 100.00) / 100.00;
        return rad;
    }

}
