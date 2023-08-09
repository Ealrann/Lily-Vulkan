/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraMatrix;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraPosition;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraScreenWorldPosition;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ECameraField;
import org.sheepy.lily.vulkan.extra.model.rendering.EMousePickMode;
import org.sheepy.lily.vulkan.extra.model.rendering.EPhysicalEntityFeature;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingFactory;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

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
			case RenderingPackage.CAMERA: return createCamera();
			case RenderingPackage.CAMERA_MATRIX: return createCameraMatrix();
			case RenderingPackage.CAMERA_POSITION: return createCameraPosition();
			case RenderingPackage.CAMERA_SCREEN_WORLD_POSITION: return createCameraScreenWorldPosition();
			case RenderingPackage.CAMERA_VARIABLE: return createCameraVariable();
			case RenderingPackage.MOUSE_PICK_CONSTANTS: return createMousePickConstants();
			case RenderingPackage.MOUSE_PICK_EXTENSION: return createMousePickExtension();
			case RenderingPackage.SELECTION_PROXY: return createSelectionProxy();
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
			case RenderingPackage.ECAMERA_FIELD:
				return createECameraFieldFromString(eDataType, initialValue);
			case RenderingPackage.EMOUSE_PICK_MODE:
				return createEMousePickModeFromString(eDataType, initialValue);
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
			case RenderingPackage.ECAMERA_FIELD:
				return convertECameraFieldToString(eDataType, instanceValue);
			case RenderingPackage.EMOUSE_PICK_MODE:
				return convertEMousePickModeToString(eDataType, instanceValue);
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
		DataProviderPkgImpl<T> dataProviderPkg = new DataProviderPkgImpl<>();
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
		DataProviderImpl<T> dataProvider = new DataProviderImpl<>();
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
		IndexedDataDescriptionImpl<T> indexedDataDescription = new IndexedDataDescriptionImpl<>();
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
		RenderableDataSourceImpl<T> renderableDataSource = new RenderableDataSourceImpl<>();
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
	@Override
	public Camera createCamera()
	{
		CameraImpl camera = new CameraImpl();
		return camera;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CameraMatrix createCameraMatrix()
	{
		CameraMatrixImpl cameraMatrix = new CameraMatrixImpl();
		return cameraMatrix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CameraPosition createCameraPosition()
	{
		CameraPositionImpl cameraPosition = new CameraPositionImpl();
		return cameraPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CameraScreenWorldPosition createCameraScreenWorldPosition()
	{
		CameraScreenWorldPositionImpl cameraScreenWorldPosition = new CameraScreenWorldPositionImpl();
		return cameraScreenWorldPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CameraVariable createCameraVariable()
	{
		CameraVariableImpl cameraVariable = new CameraVariableImpl();
		return cameraVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MousePickConstants createMousePickConstants()
	{
		MousePickConstantsImpl mousePickConstants = new MousePickConstantsImpl();
		return mousePickConstants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MousePickExtension createMousePickExtension()
	{
		MousePickExtensionImpl mousePickExtension = new MousePickExtensionImpl();
		return mousePickExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SelectionProxy createSelectionProxy()
	{
		SelectionProxyImpl selectionProxy = new SelectionProxyImpl();
		return selectionProxy;
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
	public ECameraField createECameraFieldFromString(EDataType eDataType, String initialValue)
	{
		ECameraField result = ECameraField.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertECameraFieldToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMousePickMode createEMousePickModeFromString(EDataType eDataType, String initialValue)
	{
		EMousePickMode result = EMousePickMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEMousePickModeToString(EDataType eDataType, Object instanceValue)
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
