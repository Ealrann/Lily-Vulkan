/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.vulkan.extra.model.rendering.*;
import org.sheepy.lily.vulkan.model.IResourceContainer;
import org.sheepy.lily.vulkan.model.process.IPipeline;
import org.sheepy.lily.vulkan.model.process.IProcessPart;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.resource.BufferDataProvider;
import org.sheepy.lily.vulkan.model.resource.DescribedDataProvider;
import org.sheepy.lily.vulkan.model.resource.Descriptor;

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
			case RenderingPackage.PRESENTATION:
			{
				Presentation presentation = (Presentation)theEObject;
				T1 result = casePresentation(presentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.PRESENTATION_PKG:
			{
				PresentationPkg presentationPkg = (PresentationPkg)theEObject;
				T1 result = casePresentationPkg(presentationPkg);
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
			case RenderingPackage.GENERIC_RENDERER_MAINTAINER:
			{
				GenericRendererMaintainer<?> genericRendererMaintainer = (GenericRendererMaintainer<?>)theEObject;
				T1 result = caseGenericRendererMaintainer(genericRendererMaintainer);
				if (result == null) result = caseGraphicsPipeline(genericRendererMaintainer);
				if (result == null) result = caseMaintainer(genericRendererMaintainer);
				if (result == null) result = caseIPipeline(genericRendererMaintainer);
				if (result == null) result = caseMaintainable(genericRendererMaintainer);
				if (result == null) result = caseLNamedElement(genericRendererMaintainer);
				if (result == null) result = caseIResourceContainer(genericRendererMaintainer);
				if (result == null) result = caseIProcessPart(genericRendererMaintainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.GENERIC_DATA_PROVIDER:
			{
				GenericDataProvider<?> genericDataProvider = (GenericDataProvider<?>)theEObject;
				T1 result = caseGenericDataProvider(genericDataProvider);
				if (result == null) result = caseBufferDataProvider(genericDataProvider);
				if (result == null) result = caseLNamedElement(genericDataProvider);
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
			case RenderingPackage.GENERIC_DESCRIBED_DATA_PROVIDER:
			{
				GenericDescribedDataProvider<?> genericDescribedDataProvider = (GenericDescribedDataProvider<?>)theEObject;
				T1 result = caseGenericDescribedDataProvider(genericDescribedDataProvider);
				if (result == null) result = caseGenericDataProvider(genericDescribedDataProvider);
				if (result == null) result = caseDescribedDataProvider(genericDescribedDataProvider);
				if (result == null) result = caseBufferDataProvider(genericDescribedDataProvider);
				if (result == null) result = caseDescriptor(genericDescribedDataProvider);
				if (result == null) result = caseLNamedElement(genericDescribedDataProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.RENDERABLE_DATA_SOURCE:
			{
				RenderableDataSource<?> renderableDataSource = (RenderableDataSource<?>)theEObject;
				T1 result = caseRenderableDataSource(renderableDataSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.GENERIC_VERTEX_PROVIDER:
			{
				GenericVertexProvider<?> genericVertexProvider = (GenericVertexProvider<?>)theEObject;
				T1 result = caseGenericVertexProvider(genericVertexProvider);
				if (result == null) result = caseGenericDataProvider(genericVertexProvider);
				if (result == null) result = caseBufferDataProvider(genericVertexProvider);
				if (result == null) result = caseLNamedElement(genericVertexProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case RenderingPackage.GENERIC_INDEX_PROVIDER:
			{
				GenericIndexProvider<?> genericIndexProvider = (GenericIndexProvider<?>)theEObject;
				T1 result = caseGenericIndexProvider(genericIndexProvider);
				if (result == null) result = caseGenericDataProvider(genericIndexProvider);
				if (result == null) result = caseBufferDataProvider(genericIndexProvider);
				if (result == null) result = caseLNamedElement(genericIndexProvider);
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
	 * Returns the result of interpreting the object as an instance of '<em>Presentation Pkg</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Presentation Pkg</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 casePresentationPkg(PresentationPkg object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Generic Renderer Maintainer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Renderer Maintainer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Presentation> T1 caseGenericRendererMaintainer(GenericRendererMaintainer<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Presentation> T1 caseGenericDataProvider(GenericDataProvider<T> object)
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
	public <T extends Presentation> T1 caseDataProviderPkg(DataProviderPkg<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Described Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Described Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Presentation> T1 caseGenericDescribedDataProvider(GenericDescribedDataProvider<T> object)
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
	public <T extends Presentation> T1 caseRenderableDataSource(RenderableDataSource<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Vertex Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Vertex Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Presentation> T1 caseGenericVertexProvider(GenericVertexProvider<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generic Index Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generic Index Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Presentation> T1 caseGenericIndexProvider(GenericIndexProvider<T> object)
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
	 * Returns the result of interpreting the object as an instance of '<em>IProcess Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProcess Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProcessPart(IProcessPart object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IPipeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IPipeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIPipeline(IPipeline object)
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
	 * Returns the result of interpreting the object as an instance of '<em>Buffer Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Buffer Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseBufferDataProvider(BufferDataProvider<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDescriptor(Descriptor object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Described Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Described Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseDescribedDataProvider(DescribedDataProvider<T> object)
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
