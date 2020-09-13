/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.*;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.IVulkanResource;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage
 * @generated
 */
public class RenderingAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RenderingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RenderingAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = RenderingPackage.eINSTANCE;
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
	protected RenderingSwitch<Adapter> modelSwitch =
		new RenderingSwitch<Adapter>()
		{
			@Override
			public Adapter caseEntity(Entity object)
			{
				return createEntityAdapter();
			}
			@Override
			public Adapter casePhysicalEntity(PhysicalEntity object)
			{
				return createPhysicalEntityAdapter();
			}
			@Override
			public Adapter caseAxis(Axis object)
			{
				return createAxisAdapter();
			}
			@Override
			public Adapter caseStructure(Structure object)
			{
				return createStructureAdapter();
			}
			@Override
			public Adapter casePresentation(Presentation object)
			{
				return createPresentationAdapter();
			}
			@Override
			public Adapter casePresentationPkg(PresentationPkg object)
			{
				return createPresentationPkgAdapter();
			}
			@Override
			public Adapter casePresentableEntity(PresentableEntity object)
			{
				return createPresentableEntityAdapter();
			}
			@Override
			public <T extends Structure> Adapter caseGenericRenderer(GenericRenderer<T> object)
			{
				return createGenericRendererAdapter();
			}
			@Override
			public <T extends Structure> Adapter caseRenderDataProvider(RenderDataProvider<T> object)
			{
				return createRenderDataProviderAdapter();
			}
			@Override
			public <T extends Structure> Adapter caseDataProviderPkg(DataProviderPkg<T> object)
			{
				return createDataProviderPkgAdapter();
			}
			@Override
			public <T extends Structure> Adapter caseDataProvider(DataProvider<T> object)
			{
				return createDataProviderAdapter();
			}
			@Override
			public <T extends Structure> Adapter caseRenderableDataSource(RenderableDataSource<T> object)
			{
				return createRenderableDataSourceAdapter();
			}
			@Override
			public <T extends Structure> Adapter caseVertexProvider(VertexProvider<T> object)
			{
				return createVertexProviderAdapter();
			}
			@Override
			public <T extends Structure> Adapter caseIndexProvider(IndexProvider<T> object)
			{
				return createIndexProviderAdapter();
			}
			@Override
			public Adapter caseResourceDescriptorProvider(ResourceDescriptorProvider object)
			{
				return createResourceDescriptorProviderAdapter();
			}
			@Override
			public Adapter caseDescriptorsProvider(DescriptorsProvider object)
			{
				return createDescriptorsProviderAdapter();
			}
			@Override
			public Adapter caseDataDescriptorsProvider(DataDescriptorsProvider object)
			{
				return createDataDescriptorsProviderAdapter();
			}
			@Override
			public Adapter caseDataDescriptor(DataDescriptor object)
			{
				return createDataDescriptorAdapter();
			}
			@Override
			public Adapter caseResourceDescriptorProviderPkg(ResourceDescriptorProviderPkg object)
			{
				return createResourceDescriptorProviderPkgAdapter();
			}
			@Override
			public Adapter caseRenderProxyConstantBuffer(RenderProxyConstantBuffer object)
			{
				return createRenderProxyConstantBufferAdapter();
			}
			@Override
			public Adapter caseISpecialization(ISpecialization object)
			{
				return createISpecializationAdapter();
			}
			@Override
			public <T extends Entity> Adapter caseEntityPkg(EntityPkg<T> object)
			{
				return createEntityPkgAdapter();
			}
			@Override
			public Adapter casePhysicalEntityVariable(PhysicalEntityVariable object)
			{
				return createPhysicalEntityVariableAdapter();
			}
			@Override
			public Adapter caseLNamedElement(LNamedElement object)
			{
				return createLNamedElementAdapter();
			}
			@Override
			public Adapter caseAbstractPipeline(AbstractPipeline object)
			{
				return createAbstractPipelineAdapter();
			}
			@Override
			public Adapter caseIResourceContainer(IResourceContainer object)
			{
				return createIResourceContainerAdapter();
			}
			@Override
			public Adapter caseTaskPipeline(TaskPipeline object)
			{
				return createTaskPipelineAdapter();
			}
			@Override
			public Adapter caseVkPipeline(VkPipeline object)
			{
				return createVkPipelineAdapter();
			}
			@Override
			public <T extends Maintainable<T>> Adapter caseMaintainable(Maintainable<T> object)
			{
				return createMaintainableAdapter();
			}
			@Override
			public Adapter caseGraphicsPipeline(GraphicsPipeline object)
			{
				return createGraphicsPipelineAdapter();
			}
			@Override
			public <T extends Maintainable<T>> Adapter caseMaintainer(Maintainer<T> object)
			{
				return createMaintainerAdapter();
			}
			@Override
			public Adapter caseBufferDataProvider(BufferDataProvider object)
			{
				return createBufferDataProviderAdapter();
			}
			@Override
			public Adapter caseIVulkanResource(IVulkanResource object)
			{
				return createIVulkanResourceAdapter();
			}
			@Override
			public Adapter caseConstantBuffer(ConstantBuffer object)
			{
				return createConstantBufferAdapter();
			}
			@Override
			public Adapter caseIModelVariable(IModelVariable object)
			{
				return createIModelVariableAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity <em>Physical Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntity
	 * @generated
	 */
	public Adapter createPhysicalEntityAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.Axis <em>Axis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.Axis
	 * @generated
	 */
	public Adapter createAxisAdapter()
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
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg <em>Presentation Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg
	 * @generated
	 */
	public Adapter createPresentationPkgAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity <em>Presentable Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity
	 * @generated
	 */
	public Adapter createPresentableEntityAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer <em>Generic Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer
	 * @generated
	 */
	public Adapter createGenericRendererAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider <em>Render Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderDataProvider
	 * @generated
	 */
	public Adapter createRenderDataProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg <em>Data Provider Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg
	 * @generated
	 */
	public Adapter createDataProviderPkgAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataProvider <em>Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataProvider
	 * @generated
	 */
	public Adapter createDataProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource <em>Renderable Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderableDataSource
	 * @generated
	 */
	public Adapter createRenderableDataSourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider <em>Vertex Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.VertexProvider
	 * @generated
	 */
	public Adapter createVertexProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider <em>Index Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.IndexProvider
	 * @generated
	 */
	public Adapter createIndexProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider <em>Resource Descriptor Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider
	 * @generated
	 */
	public Adapter createResourceDescriptorProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider <em>Descriptors Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider
	 * @generated
	 */
	public Adapter createDescriptorsProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider <em>Data Descriptors Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider
	 * @generated
	 */
	public Adapter createDataDescriptorsProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor <em>Data Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor
	 * @generated
	 */
	public Adapter createDataDescriptorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg <em>Resource Descriptor Provider Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg
	 * @generated
	 */
	public Adapter createResourceDescriptorProviderPkgAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer <em>Render Proxy Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer
	 * @generated
	 */
	public Adapter createRenderProxyConstantBufferAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization <em>ISpecialization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization
	 * @generated
	 */
	public Adapter createISpecializationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg <em>Entity Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.EntityPkg
	 * @generated
	 */
	public Adapter createEntityPkgAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable <em>Physical Entity Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.extra.model.rendering.PhysicalEntityVariable
	 * @generated
	 */
	public Adapter createPhysicalEntityVariableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.types.LNamedElement <em>LNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.types.LNamedElement
	 * @generated
	 */
	public Adapter createLNamedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.AbstractPipeline <em>Abstract Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.AbstractPipeline
	 * @generated
	 */
	public Adapter createAbstractPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IResourceContainer <em>IResource Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IResourceContainer
	 * @generated
	 */
	public Adapter createIResourceContainerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.TaskPipeline <em>Task Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.TaskPipeline
	 * @generated
	 */
	public Adapter createTaskPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.VkPipeline <em>Vk Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.VkPipeline
	 * @generated
	 */
	public Adapter createVkPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.maintainer.Maintainable <em>Maintainable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.maintainer.Maintainable
	 * @generated
	 */
	public Adapter createMaintainableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline <em>Graphics Pipeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline
	 * @generated
	 */
	public Adapter createGraphicsPipelineAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.maintainer.Maintainer <em>Maintainer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.maintainer.Maintainer
	 * @generated
	 */
	public Adapter createMaintainerAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider <em>Buffer Data Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.BufferDataProvider
	 * @generated
	 */
	public Adapter createBufferDataProviderAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.IVulkanResource <em>IVulkan Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.IVulkanResource
	 * @generated
	 */
	public Adapter createIVulkanResourceAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer <em>Constant Buffer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer
	 * @generated
	 */
	public Adapter createConstantBufferAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.sheepy.lily.core.model.variable.IModelVariable <em>IModel Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.sheepy.lily.core.model.variable.IModelVariable
	 * @generated
	 */
	public Adapter createIModelVariableAdapter()
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

} //RenderingAdapterFactory
