/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.variable.IModelVariable;
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
import org.sheepy.lily.vulkan.extra.model.rendering.Entity;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.EntityResolverPipeline;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntityResolver;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntitySelection;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.SelectionProxy;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.StructurePkg;
import org.sheepy.lily.vulkan.extra.model.rendering.Structures;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.IProcessExtension;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage
 * @generated
 */
public class RenderingSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RenderingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenderingSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = RenderingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case RenderingPackage.ENTITY:
			{
				Entity entity = (Entity)theEObject;
				T1 result = caseEntity(entity);
				if (result == null) result = caseLNamedElement(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.PHYSICAL_ENTITY:
			{
				PhysicalEntity physicalEntity = (PhysicalEntity)theEObject;
				T1 result = casePhysicalEntity(physicalEntity);
				if (result == null) result = caseEntity(physicalEntity);
				if (result == null) result = caseLNamedElement(physicalEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.AXIS:
			{
				Axis axis = (Axis)theEObject;
				T1 result = caseAxis(axis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.STRUCTURE:
			{
				Structure structure = (Structure)theEObject;
				T1 result = caseStructure(structure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.PRESENTATION:
			{
				Presentation presentation = (Presentation)theEObject;
				T1 result = casePresentation(presentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.STRUCTURE_PKG:
			{
				StructurePkg structurePkg = (StructurePkg)theEObject;
				T1 result = caseStructurePkg(structurePkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.STRUCTURES:
			{
				Structures structures = (Structures)theEObject;
				T1 result = caseStructures(structures);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.PRESENTABLE_ENTITY:
			{
				PresentableEntity presentableEntity = (PresentableEntity)theEObject;
				T1 result = casePresentableEntity(presentableEntity);
				if (result == null) result = casePhysicalEntity(presentableEntity);
				if (result == null) result = caseEntity(presentableEntity);
				if (result == null) result = caseLNamedElement(presentableEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.GENERIC_RENDERER:
			{
				GenericRenderer<?> genericRenderer = (GenericRenderer<?>)theEObject;
				T1 result = caseGenericRenderer(genericRenderer);
				if (result == null) result = caseGraphicsPipeline(genericRenderer);
				if (result == null) result = caseMaintainer(genericRenderer);
				if (result == null) result = caseVkPipeline(genericRenderer);
				if (result == null) result = caseMaintainable(genericRenderer);
				if (result == null) result = caseTaskPipeline(genericRenderer);
				if (result == null) result = caseAbstractPipeline(genericRenderer);
				if (result == null) result = caseIResourceContainer(genericRenderer);
				if (result == null) result = caseLNamedElement(genericRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.DATA_PROVIDER_PKG:
			{
				DataProviderPkg<?> dataProviderPkg = (DataProviderPkg<?>)theEObject;
				T1 result = caseDataProviderPkg(dataProviderPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.DATA_PROVIDER:
			{
				DataProvider<?> dataProvider = (DataProvider<?>)theEObject;
				T1 result = caseDataProvider(dataProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.INDEXED_DATA_DESCRIPTION:
			{
				IndexedDataDescription<?> indexedDataDescription = (IndexedDataDescription<?>)theEObject;
				T1 result = caseIndexedDataDescription(indexedDataDescription);
				if (result == null) result = caseDataProvider(indexedDataDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.RENDERABLE_DATA_SOURCE:
			{
				RenderableDataSource<?> renderableDataSource = (RenderableDataSource<?>)theEObject;
				T1 result = caseRenderableDataSource(renderableDataSource);
				if (result == null) result = caseIBufferDataSource(renderableDataSource);
				if (result == null) result = caseIVulkanResource(renderableDataSource);
				if (result == null) result = caseLNamedElement(renderableDataSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER:
			{
				ResourceDescriptorProvider resourceDescriptorProvider = (ResourceDescriptorProvider)theEObject;
				T1 result = caseResourceDescriptorProvider(resourceDescriptorProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.DESCRIPTORS_PROVIDER:
			{
				DescriptorsProvider descriptorsProvider = (DescriptorsProvider)theEObject;
				T1 result = caseDescriptorsProvider(descriptorsProvider);
				if (result == null) result = caseResourceDescriptorProvider(descriptorsProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.DATA_DESCRIPTORS_PROVIDER:
			{
				DataDescriptorsProvider dataDescriptorsProvider = (DataDescriptorsProvider)theEObject;
				T1 result = caseDataDescriptorsProvider(dataDescriptorsProvider);
				if (result == null) result = caseResourceDescriptorProvider(dataDescriptorsProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.DATA_DESCRIPTOR:
			{
				DataDescriptor dataDescriptor = (DataDescriptor)theEObject;
				T1 result = caseDataDescriptor(dataDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.RESOURCE_DESCRIPTOR_PROVIDER_PKG:
			{
				ResourceDescriptorProviderPkg resourceDescriptorProviderPkg = (ResourceDescriptorProviderPkg)theEObject;
				T1 result = caseResourceDescriptorProviderPkg(resourceDescriptorProviderPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER:
			{
				RenderProxyConstantBuffer renderProxyConstantBuffer = (RenderProxyConstantBuffer)theEObject;
				T1 result = caseRenderProxyConstantBuffer(renderProxyConstantBuffer);
				if (result == null) result = caseConstantBuffer(renderProxyConstantBuffer);
				if (result == null) result = caseIVulkanResource(renderProxyConstantBuffer);
				if (result == null) result = caseLNamedElement(renderProxyConstantBuffer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.ISPECIALIZATION:
			{
				ISpecialization iSpecialization = (ISpecialization)theEObject;
				T1 result = caseISpecialization(iSpecialization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.ENTITY_PKG:
			{
				EntityPkg<?> entityPkg = (EntityPkg<?>)theEObject;
				T1 result = caseEntityPkg(entityPkg);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.PHYSICAL_ENTITY_VARIABLE:
			{
				PhysicalEntityVariable physicalEntityVariable = (PhysicalEntityVariable)theEObject;
				T1 result = casePhysicalEntityVariable(physicalEntityVariable);
				if (result == null) result = caseIModelVariable(physicalEntityVariable);
				if (result == null) result = caseLNamedElement(physicalEntityVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.CAMERA:
			{
				Camera camera = (Camera)theEObject;
				T1 result = caseCamera(camera);
				if (result == null) result = caseIRootResource(camera);
				if (result == null) result = caseLNamedElement(camera);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.CAMERA_MATRIX:
			{
				CameraMatrix cameraMatrix = (CameraMatrix)theEObject;
				T1 result = caseCameraMatrix(cameraMatrix);
				if (result == null) result = caseIModelVariable(cameraMatrix);
				if (result == null) result = caseLNamedElement(cameraMatrix);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.CAMERA_POSITION:
			{
				CameraPosition cameraPosition = (CameraPosition)theEObject;
				T1 result = caseCameraPosition(cameraPosition);
				if (result == null) result = caseIModelVariable(cameraPosition);
				if (result == null) result = caseLNamedElement(cameraPosition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.CAMERA_SCREEN_WORLD_POSITION:
			{
				CameraScreenWorldPosition cameraScreenWorldPosition = (CameraScreenWorldPosition)theEObject;
				T1 result = caseCameraScreenWorldPosition(cameraScreenWorldPosition);
				if (result == null) result = caseIModelVariable(cameraScreenWorldPosition);
				if (result == null) result = caseLNamedElement(cameraScreenWorldPosition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.CAMERA_VARIABLE:
			{
				CameraVariable cameraVariable = (CameraVariable)theEObject;
				T1 result = caseCameraVariable(cameraVariable);
				if (result == null) result = caseIModelVariable(cameraVariable);
				if (result == null) result = caseLNamedElement(cameraVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.MOUSE_PICK_CONSTANTS:
			{
				MousePickConstants mousePickConstants = (MousePickConstants)theEObject;
				T1 result = caseMousePickConstants(mousePickConstants);
				if (result == null) result = caseConstantBuffer(mousePickConstants);
				if (result == null) result = caseIVulkanResource(mousePickConstants);
				if (result == null) result = caseLNamedElement(mousePickConstants);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.MOUSE_PICK_EXTENSION:
			{
				MousePickExtension mousePickExtension = (MousePickExtension)theEObject;
				T1 result = caseMousePickExtension(mousePickExtension);
				if (result == null) result = caseIProcessExtension(mousePickExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.ENTITY_RESOLVER_PIPELINE:
			{
				EntityResolverPipeline entityResolverPipeline = (EntityResolverPipeline)theEObject;
				T1 result = caseEntityResolverPipeline(entityResolverPipeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.IENTITY_RESOLVER:
			{
				IEntityResolver iEntityResolver = (IEntityResolver)theEObject;
				T1 result = caseIEntityResolver(iEntityResolver);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.IENTITY_SELECTION:
			{
				IEntitySelection iEntitySelection = (IEntitySelection)theEObject;
				T1 result = caseIEntitySelection(iEntitySelection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.SELECTION_PROXY:
			{
				SelectionProxy selectionProxy = (SelectionProxy)theEObject;
				T1 result = caseSelectionProxy(selectionProxy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEntity(Entity object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Physical Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Physical Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePhysicalEntity(PhysicalEntity object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Axis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Axis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAxis(Axis object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStructure(Structure object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePresentation(Presentation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structure Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structure Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStructurePkg(StructurePkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structures</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structures</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStructures(Structures object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Presentable Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentable Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePresentableEntity(PresentableEntity object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Renderer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Structure> T1 caseGenericRenderer(GenericRenderer<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Provider Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Provider Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Structure> T1 caseDataProviderPkg(DataProviderPkg<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Structure> T1 caseDataProvider(DataProvider<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Indexed Data Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Indexed Data Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Structure> T1 caseIndexedDataDescription(IndexedDataDescription<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Renderable Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Renderable Data Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Structure> T1 caseRenderableDataSource(RenderableDataSource<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Descriptor Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Descriptor Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResourceDescriptorProvider(ResourceDescriptorProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptors Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptors Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDescriptorsProvider(DescriptorsProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Descriptors Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Descriptors Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDataDescriptorsProvider(DataDescriptorsProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDataDescriptor(DataDescriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Descriptor Provider Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Descriptor Provider Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseResourceDescriptorProviderPkg(ResourceDescriptorProviderPkg object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Render Proxy Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Render Proxy Constant Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRenderProxyConstantBuffer(RenderProxyConstantBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ISpecialization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ISpecialization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseISpecialization(ISpecialization object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Entity> T1 caseEntityPkg(EntityPkg<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Physical Entity Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Physical Entity Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePhysicalEntityVariable(PhysicalEntityVariable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Camera</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Camera</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCamera(Camera object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Camera Matrix</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Camera Matrix</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCameraMatrix(CameraMatrix object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Camera Position</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Camera Position</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCameraPosition(CameraPosition object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Camera Screen World Position</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Camera Screen World Position</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCameraScreenWorldPosition(CameraScreenWorldPosition object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Camera Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Camera Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCameraVariable(CameraVariable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Pick Constants</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Pick Constants</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMousePickConstants(MousePickConstants object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mouse Pick Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mouse Pick Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMousePickExtension(MousePickExtension object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity Resolver Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity Resolver Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEntityResolverPipeline(EntityResolverPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEntity Resolver</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEntity Resolver</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIEntityResolver(IEntityResolver object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IEntity Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IEntity Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIEntitySelection(IEntitySelection object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Proxy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Proxy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSelectionProxy(SelectionProxy object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LNamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLNamedElement(LNamedElement object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAbstractPipeline(AbstractPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IResource Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IResource Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIResourceContainer(IResourceContainer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTaskPipeline(TaskPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vk Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vk Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseVkPipeline(VkPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maintainable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maintainable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Maintainable<T>> T1 caseMaintainable(Maintainable<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphics Pipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphics Pipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGraphicsPipeline(GraphicsPipeline object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maintainer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maintainer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Maintainable<T>> T1 caseMaintainer(Maintainer<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IBuffer Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IBuffer Data Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIBufferDataSource(IBufferDataSource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IVulkan Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IVulkan Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIVulkanResource(IVulkanResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Buffer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConstantBuffer(ConstantBuffer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IModel Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IModel Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIModelVariable(IModelVariable object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRoot Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRoot Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIRootResource(IRootResource object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProcess Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProcessExtension(IProcessExtension object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object)
	{
		return null;
	}

} //RenderingSwitch
