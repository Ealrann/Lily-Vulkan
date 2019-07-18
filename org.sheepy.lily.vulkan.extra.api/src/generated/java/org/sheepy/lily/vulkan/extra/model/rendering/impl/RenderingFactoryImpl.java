/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.sheepy.lily.vulkan.extra.model.rendering.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RenderingFactoryImpl extends EFactoryImpl implements RenderingFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RenderingFactory init()
	{
		try
		{
			RenderingFactory theRenderingFactory = (RenderingFactory)EPackage.Registry.INSTANCE.getEFactory(RenderingPackage.eNS_URI);
			if (theRenderingFactory != null)
			{
				return theRenderingFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new RenderingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenderingFactoryImpl()
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
			case RenderingPackage.AXIS: return createAxis();
			case RenderingPackage.PRESENTATION_PKG: return createPresentationPkg();
			case RenderingPackage.PRESENTABLE_ENTITY: return createPresentableEntity();
			case RenderingPackage.DATA_PROVIDER_PKG: return createDataProviderPkg();
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER: return createGenericDescribedDataProvider();
			case RenderingPackage.RENDERABLE_DATA_SOURCE: return createRenderableDataSource();
			case RenderingPackage.GENERIC_VERTEX_PROVIDER: return createGenericVertexProvider();
			case RenderingPackage.GENERIC_INDEX_PROVIDER: return createGenericIndexProvider();
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
	public Axis createAxis()
	{
		AxisImpl axis = new AxisImpl();
		return axis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PresentationPkg createPresentationPkg()
	{
		PresentationPkgImpl presentationPkg = new PresentationPkgImpl();
		return presentationPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PresentableEntity createPresentableEntity()
	{
		PresentableEntityImpl presentableEntity = new PresentableEntityImpl();
		return presentableEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends Presentation> DataProviderPkg<T> createDataProviderPkg()
	{
		DataProviderPkgImpl<T> dataProviderPkg = new DataProviderPkgImpl<T>();
		return dataProviderPkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends Presentation> GenericDescribedDataProvider<T> createGenericDescribedDataProvider()
	{
		GenericDescribedDataProviderImpl<T> genericDescribedDataProvider = new GenericDescribedDataProviderImpl<T>();
		return genericDescribedDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends Presentation> RenderableDataSource<T> createRenderableDataSource()
	{
		RenderableDataSourceImpl<T> renderableDataSource = new RenderableDataSourceImpl<T>();
		return renderableDataSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends Presentation> GenericVertexProvider<T> createGenericVertexProvider()
	{
		GenericVertexProviderImpl<T> genericVertexProvider = new GenericVertexProviderImpl<T>();
		return genericVertexProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends Presentation> GenericIndexProvider<T> createGenericIndexProvider()
	{
		GenericIndexProviderImpl<T> genericIndexProvider = new GenericIndexProviderImpl<T>();
		return genericIndexProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderingPackage getRenderingPackage()
	{
		return (RenderingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static RenderingPackage getPackage()
	{
		return RenderingPackage.eINSTANCE;
	}

} //RenderingFactoryImpl
