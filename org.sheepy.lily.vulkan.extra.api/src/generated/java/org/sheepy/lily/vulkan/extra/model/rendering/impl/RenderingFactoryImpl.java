/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
			case RenderingPackage.DATA_PROVIDER: return createDataProvider();
			case RenderingPackage.INDEXED_DATA_DESCRIPTION: return createIndexedDataDescription();
			case RenderingPackage.RENDERABLE_DATA_SOURCE: return createRenderableDataSource();
			case RenderingPackage.DESCRIPTORS_PROVIDER: return createDescriptorsProvider();
			case RenderingPackage.DATA_DESCRIPTORS_PROVIDER: return createDataDescriptorsProvider();
			case RenderingPackage.DATA_DESCRIPTOR: return createDataDescriptor();
			case RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_PKG: return createResourceDescriptorProviderPkg();
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER: return createRenderProxyConstantBuffer();
			case RenderingPackage.ISPECIALIZATION: return createISpecialization();
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE: return createPhysicalEntityVariable();
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
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case RenderingPackage.EPHYSICAL_ENTITY_FEATURE:
				return createEPhysicalEntityFeatureFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case RenderingPackage.EPHYSICAL_ENTITY_FEATURE:
				return convertEPhysicalEntityFeatureToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public <T extends Structure> DataProvider<T> createDataProvider()
	{
		DataProviderImpl<T> dataProvider = new DataProviderImpl<T>();
		return dataProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public <T extends Structure> IndexedDataDescription<T> createIndexedDataDescription()
	{
		IndexedDataDescriptionImpl<T> indexedDataDescription = new IndexedDataDescriptionImpl<T>();
		return indexedDataDescription;
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
	public DescriptorsProvider createDescriptorsProvider()
	{
		DescriptorsProviderImpl descriptorsProvider = new DescriptorsProviderImpl();
		return descriptorsProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataDescriptorsProvider createDataDescriptorsProvider()
	{
		DataDescriptorsProviderImpl dataDescriptorsProvider = new DataDescriptorsProviderImpl();
		return dataDescriptorsProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DataDescriptor createDataDescriptor()
	{
		DataDescriptorImpl dataDescriptor = new DataDescriptorImpl();
		return dataDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceDescriptorProviderPkg createResourceDescriptorProviderPkg()
	{
		ResourceDescriptorProviderPkgImpl resourceDescriptorProviderPkg = new ResourceDescriptorProviderPkgImpl();
		return resourceDescriptorProviderPkg;
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
	public PhysicalEntityVariable createPhysicalEntityVariable()
	{
		PhysicalEntityVariableImpl physicalEntityVariable = new PhysicalEntityVariableImpl();
		return physicalEntityVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPhysicalEntityFeature createEPhysicalEntityFeatureFromString(EDataType eDataType, String initialValue)
	{
		EPhysicalEntityFeature result = EPhysicalEntityFeature.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEPhysicalEntityFeatureToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
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
