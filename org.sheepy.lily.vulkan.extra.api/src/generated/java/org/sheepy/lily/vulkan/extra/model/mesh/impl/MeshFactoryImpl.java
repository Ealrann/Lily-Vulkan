/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.extra.model.mesh.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MeshFactoryImpl extends EFactoryImpl implements MeshFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MeshFactory init()
	{
		try {
			MeshFactory theMeshFactory = (MeshFactory)EPackage.Registry.INSTANCE.getEFactory(MeshPackage.eNS_URI);
			if (theMeshFactory != null) {
				return theMeshFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MeshFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeshFactoryImpl()
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
		switch (eClass.getClassifierID()) {
			case MeshPackage.MESH_RENDERER: return createMeshRenderer();
			case MeshPackage.IMESH_STRUCTURE: return createIMeshStructure();
			case MeshPackage.GEOMETRIC_MESH: return createGeometricMesh();
			case MeshPackage.ICOSAHEDRON: return createIcosahedron();
			case MeshPackage.SPHERE: return createSphere();
			case MeshPackage.ICO_SPHERE: return createIcoSphere();
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
	public MeshRenderer createMeshRenderer()
	{
		MeshRendererImpl meshRenderer = new MeshRendererImpl();
		return meshRenderer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IMeshStructure createIMeshStructure()
	{
		IMeshStructureImpl iMeshStructure = new IMeshStructureImpl();
		return iMeshStructure;
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
	public MeshPackage getMeshPackage()
	{
		return (MeshPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MeshPackage getPackage()
	{
		return MeshPackage.eINSTANCE;
	}

} //MeshFactoryImpl
