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
			case RenderingPackage.DESCRIBED_DATA_PROVIDER: return createDescribedDataProvider();
			case RenderingPackage.RENDERABLE_DATA_SOURCE: return createRenderableDataSource();
			case RenderingPackage.VERTEX_PROVIDER: return createVertexProvider();
			case RenderingPackage.INDEX_PROVIDER: return createIndexProvider();
			case RenderingPackage.STATIC_RESOURCE_PROVIDER: return createStaticResourceProvider();
			case RenderingPackage.COMPOSITE_RESOURCE_PROVIDER: return createCompositeResourceProvider();
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER: return createRenderProxyConstantBuffer();
			case RenderingPackage.ISPECIALIZATION: return createISpecialization();
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
	public <T extends Structure> DataProviderPkg<T> createDataProviderPkg()
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
	public <T extends Structure> DescribedDataProvider<T> createDescribedDataProvider()
	{
		DescribedDataProviderImpl<T> describedDataProvider = new DescribedDataProviderImpl<T>();
		return describedDataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends Structure> RenderableDataSource<T> createRenderableDataSource()
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
	public <T extends Structure> VertexProvider<T> createVertexProvider()
	{
		VertexProviderImpl<T> vertexProvider = new VertexProviderImpl<T>();
		return vertexProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends Structure> IndexProvider<T> createIndexProvider()
	{
		IndexProviderImpl<T> indexProvider = new IndexProviderImpl<T>();
		return indexProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StaticResourceProvider createStaticResourceProvider()
	{
		StaticResourceProviderImpl staticResourceProvider = new StaticResourceProviderImpl();
		return staticResourceProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompositeResourceProvider createCompositeResourceProvider()
	{
		CompositeResourceProviderImpl compositeResourceProvider = new CompositeResourceProviderImpl();
		return compositeResourceProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderProxyConstantBuffer createRenderProxyConstantBuffer()
	{
		RenderProxyConstantBufferImpl renderProxyConstantBuffer = new RenderProxyConstantBufferImpl();
		return renderProxyConstantBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ISpecialization createISpecialization()
	{
		ISpecializationImpl iSpecialization = new ISpecializationImpl();
		return iSpecialization;
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
