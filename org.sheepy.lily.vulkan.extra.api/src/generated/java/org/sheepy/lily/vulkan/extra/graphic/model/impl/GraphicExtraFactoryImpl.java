/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.extra.graphic.model.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicExtraFactoryImpl extends EFactoryImpl implements GraphicExtraFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphicExtraFactory init()
	{
		try
		{
			GraphicExtraFactory theGraphicExtraFactory = (GraphicExtraFactory)EPackage.Registry.INSTANCE.getEFactory(GraphicExtraPackage.eNS_URI);
			if (theGraphicExtraFactory != null)
			{
				return theGraphicExtraFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphicExtraFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicExtraFactoryImpl()
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
			case GraphicExtraPackage.MESH_PROVIDER: return createMeshProvider();
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER: return createComplexMeshProvider();
			case GraphicExtraPackage.VERTEX_DATA_PROVIDER: return createVertexDataProvider();
			case GraphicExtraPackage.INDEX_DATA_PROVIDER: return createIndexDataProvider();
			case GraphicExtraPackage.UNIFORM_DATA_PROVIDER: return createUniformDataProvider();
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
	public MeshProvider createMeshProvider()
	{
		MeshProviderImpl meshProvider = new MeshProviderImpl();
		return meshProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComplexMeshProvider createComplexMeshProvider()
	{
		ComplexMeshProviderImpl complexMeshProvider = new ComplexMeshProviderImpl();
		return complexMeshProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VertexDataProvider createVertexDataProvider()
	{
		VertexDataProviderImpl vertexDataProvider = new VertexDataProviderImpl();
		return vertexDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IndexDataProvider createIndexDataProvider()
	{
		IndexDataProviderImpl indexDataProvider = new IndexDataProviderImpl();
		return indexDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UniformDataProvider createUniformDataProvider()
	{
		UniformDataProviderImpl uniformDataProvider = new UniformDataProviderImpl();
		return uniformDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicExtraPackage getGraphicExtraPackage()
	{
		return (GraphicExtraPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphicExtraPackage getPackage()
	{
		return GraphicExtraPackage.eINSTANCE;
	}

} //GraphicExtraFactoryImpl
