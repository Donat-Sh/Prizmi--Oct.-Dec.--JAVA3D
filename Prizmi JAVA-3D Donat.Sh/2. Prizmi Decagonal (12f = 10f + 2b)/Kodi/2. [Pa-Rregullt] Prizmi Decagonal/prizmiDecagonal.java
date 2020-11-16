import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;

public class prizmiDecagonal extends Shape3D
{
  public prizmiDecagonal()
   {
     GeometryInfo gi = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
      double moveX = 0.2;
     // double offset = 0;
     Point3d[] vertices =
         {         
        		 new Point3d(0.0 - moveX, 0.0, 1.046657), //0 baza1
                 new Point3d(0.5904836, 0.0, 0.8641878), 
                 new Point3d(-0.05638617- moveX, 0.5877853, 0.8641878), // 2 baza2
                 new Point3d(-0.5797148-moveX, -0.112257, 0.8641878),  // 3 baza 
                 new Point3d(0.5340974 - moveX, 0.5877853, 0.6817184), // 4 baza 2
                 new Point3d(0.9661914-moveX, -0.112257, 0.3864765),  // 5 baza1
                 new Point3d(-0.636101, 0.4755283, 0.6817184),
                 new Point3d(-0.9272295 - moveX, -0.2938926, 0.3864765), // 7baza1
                 new Point3d(0.9098052 -moveX , 0.4755283, 0.2040071),  // 8  baza2
                 new Point3d(0.9836156- moveX, -0.2938926, -0.2040071), //9 baza1
                 new Point3d(-0.9836156 - moveX, 0.2938926, 0.2040071), // 10 baza2
                 new Point3d(-0.9098052, -0.4755283, -0.2040071), //11
                 new Point3d(0.9272295, 0.2938926, -0.3864765),
                 new Point3d(0.636101-moveX, -0.4755283, -0.6817184),  // 13 baza1
                 new Point3d(-0.9661914 - moveX, 0.112257, -0.3864765), // baza2 
                 new Point3d(-0.5340974, -0.5877853, -0.6817184), // 15 baza1
                 new Point3d(0.5797148, 0.112257, -0.8641878),  
                 new Point3d(0.05638617-moveX, -0.5877853, -0.8641878), // 17 baza1
                 new Point3d(-0.5904836- moveX, 0.0, -0.8641878),  // 18 baza2 
                 new Point3d(0.0 - moveX, 0.0, -1.046657)      // 19 baza2
                 }; 
       

      int[] indices =
           {
            0,1,4,2
           ,0,2,6,3
           ,1,5,8,4
           ,3,6,10,7
           ,5,9,12,8
           ,7,10,14,11
           ,9,13,16,12
           ,11,14,18,15
           ,13,17,19,16
           ,15,18,19,17
           ,0,3,7,11,15,17,13,9,5,1   // baza 1
           ,2,4,8,12,16,19,18,14,10,6  // baza 2
          };
        

      gi.setCoordinates(vertices);
      gi.setCoordinateIndices(indices);

      int[] stripCounts = {4,4,4,4,4,4,4,4,4,4,10,10};
      gi.setStripCounts(stripCounts);
      
      NormalGenerator ng = new NormalGenerator();
      ng.generateNormals(gi);
      
      this.setGeometry(gi.getGeometryArray());
   }
}