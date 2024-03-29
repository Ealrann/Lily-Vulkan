/**
 */
package org.sheepy.lily.vulkan.extra.model.shape.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.vulkan.extra.model.mesh.IMeshStructure;
import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh;
import org.sheepy.lily.vulkan.extra.model.shape.GeometricStructure;
import org.sheepy.lily.vulkan.extra.model.shape.IcoSphere;
import org.sheepy.lily.vulkan.extra.model.shape.Icosahedron;
import org.sheepy.lily.vulkan.extra.model.shape.ShapePackage;
import org.sheepy.lily.vulkan.extra.model.shape.Sphere;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.shape.ShapePackage
 * @generated
 */
public class ShapeAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ShapePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShapeAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = ShapePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShapeSwitch<Adapter> modelSwitch =
		new ShapeSwitch<>()
		{
			@Override
			public Adapter caseGeometricStructure(GeometricStructure object)
			{
				return createGeometricStructureAdapter();
			}
			@Override
			public Adapter caseGeometricMesh(GeometricMesh object)
			{
				return createGeometricMeshAdapter();
			}
			@Override
			public Adapter caseIcosahedron(Icosahedron object)
			{
				return createIcosahedronAdapter();
			}
			@Override
			public Adapter caseSphere(Sphere object)
			{
				return createSphereAdapter();
			}
			@Override
			public Adapter caseIcoSphere(IcoSphere object)
			{
				return createIcoSphereAdapter();
			}
			@Override
			public Adapter caseStructure(Structure object)
			{
				return createStructureAdapter();
			}
			@Override
			public Adapter caseIMeshStructure(IMeshStructure object)
			{
				return createIMeshStructureAdapter();
			}
			@Override
			public <T extends Mesh> Adapter caseMeshStructure(MeshStructure<T> object)
			{
				return createMeshStructureAdapter();
			}
			@Override
			public Adapter casePresentation(Presentation object)
			{
				return createPresentationAdapter();
			}
			@Override
			public Adapter caseMesh(Mesh object)
			{
				return createMeshAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.shape.GeometricStructure <em>Geometric Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.GeometricStructure
	 * @generated
	 */
	public Adapter createGeometricStructureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh <em>Geometric Mesh</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh
	 * @generated
	 */
	public Adapter createGeometricMeshAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.shape.Icosahedron <em>Icosahedron</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.Icosahedron
	 * @generated
	 */
	public Adapter createIcosahedronAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.shape.Sphere <em>Sphere</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.Sphere
	 * @generated
	 */
	public Adapter createSphereAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.shape.IcoSphere <em>Ico Sphere</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.shape.IcoSphere
	 * @generated
	 */
	public Adapter createIcoSphereAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Structure
	 * @generated
	 */
	public Adapter createStructureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.mesh.IMeshStructure <em>IMesh Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.IMeshStructure
	 * @generated
	 */
	public Adapter createIMeshStructureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure
	 * @generated
	 */
	public Adapter createMeshStructureAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Presentation <em>Presentation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Presentation
	 * @generated
	 */
	public Adapter createPresentationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.mesh.Mesh <em>Mesh</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.mesh.Mesh
	 * @generated
	 */
	public Adapter createMeshAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //ShapeAdapterFactory
