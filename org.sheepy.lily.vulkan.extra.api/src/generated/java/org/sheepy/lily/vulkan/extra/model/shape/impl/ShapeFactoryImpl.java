/**
 */
package org.sheepy.lily.vulkan.extra.model.shape.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh;
import org.sheepy.lily.vulkan.extra.model.shape.IcoSphere;
import org.sheepy.lily.vulkan.extra.model.shape.Icosahedron;
import org.sheepy.lily.vulkan.extra.model.shape.ShapeFactory;
import org.sheepy.lily.vulkan.extra.model.shape.ShapePackage;
import org.sheepy.lily.vulkan.extra.model.shape.Sphere;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ShapeFactoryImpl extends EFactoryImpl implements ShapeFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ShapeFactory init()
	{
		try
		{
			ShapeFactory theShapeFactory = (ShapeFactory)EPackage.Registry.INSTANCE.getEFactory(ShapePackage.eNS_URI);
			if (theShapeFactory != null)
			{
				return theShapeFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ShapeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShapeFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case ShapePackage.GEOMETRIC_MESH: return createGeometricMesh();
			case ShapePackage.ICOSAHEDRON: return createIcosahedron();
			case ShapePackage.SPHERE: return createSphere();
			case ShapePackage.ICO_SPHERE: return createIcoSphere();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GeometricMesh createGeometricMesh()
	{
		GeometricMeshImpl geometricMesh = new GeometricMeshImpl();
		return geometricMesh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Icosahedron createIcosahedron()
	{
		IcosahedronImpl icosahedron = new IcosahedronImpl();
		return icosahedron;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Sphere createSphere()
	{
		SphereImpl sphere = new SphereImpl();
		return sphere;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IcoSphere createIcoSphere()
	{
		IcoSphereImpl icoSphere = new IcoSphereImpl();
		return icoSphere;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ShapePackage getShapePackage()
	{
		return (ShapePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ShapePackage getPackage()
	{
		return ShapePackage.eINSTANCE;
	}

} //ShapeFactoryImpl
