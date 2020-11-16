import javax.vecmath.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
import com.sun.j3d.utils.geometry.*;

public class prizmiOctagonal extends Shape3D
{
  public prizmiOctagonal()
   {
     GeometryInfo gi = new GeometryInfo(GeometryInfo.POLYGON_ARRAY);
     double phi = 0.5*(Math.sqrt(5)+1);
     
     Point3d[] vertices =
         {
          new Point3d(0.0, 0.0, 1.070722),
          new Point3d(0.7148135, 0.0, 0.7971752),
          new Point3d(-0.304682, 0.7071068, 0.7971752),
          new Point3d(-0.6841528, -0.2071068, 0.7971752),
          new Point3d(0.8101315, 0.7071068, 0.5236279),
          new Point3d(1.04156, -0.2071068, 0.1367736),
          new Point3d(-0.7888348, 0.5, 0.3236279),
          new Point3d(-0.9368776, -0.5, 0.1367736),
          new Point3d(0.9368776, 0.5, -0.1367736),
          new Point3d(0.7888348, -0.5, -0.5236279),
          new Point3d(-1.04156, 0.4071068, -0.1367736),
          new Point3d(-0.5101315, -0.7071068, -0.5236279),
          new Point3d(0.6841528, 0.2071068, -0.7971752),
          new Point3d(0.304682, -0.7071068, -0.7971752),
          new Point3d(-0.7148135, 0.0, -0.7971752),
          new Point3d(0.0, 0.0, -1.070722)
        }; 
       

      int[] indices =
           {
             0,1,4,2
            ,0,2,6,3
            ,1,5,8,4
            ,3,6,10,7
            ,5,9,12,8
            ,7,10,14,11
            ,9,13,15,12
            ,11,14,15,13
            ,0,3,7,11,13,9,5,1
            ,2,4,8,12,15,14,10,6       
          };
        

      gi.setCoordinates(vertices);
      gi.setCoordinateIndices(indices);

      int[] stripCounts = {4,4,4,4,4,4,4,4,8,8};
      gi.setStripCounts(stripCounts);
      
      NormalGenerator ng = new NormalGenerator();
      ng.generateNormals(gi);
      
      this.setGeometry(gi.getGeometryArray());
   }
}