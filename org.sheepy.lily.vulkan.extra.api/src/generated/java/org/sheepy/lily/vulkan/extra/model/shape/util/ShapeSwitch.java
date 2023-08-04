/**
 */
package org.sheepy.lily.vulkan.extra.model.shape.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

import org.sheepy.lily.vulkan.extra.model.shape.*;

import org.sheepy.lily.vulkan.model.IResourceContainer;

import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.VkPipeline;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;

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
 * @see org.sheepy.lily.vulkan.extra.model.shape.ShapePackage
 * @generated
 */
public class ShapeSwitch<T1> extends Switch<T1>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ShapePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShapeSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = ShapePackage.eINSTANCE;
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
			case ShapePackage.MESH:
			{
				Mesh mesh = (Mesh)theEObject;
				T1 result = caseMesh(mesh);
				if (result == null) result = casePresentation(mesh);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ShapePackage.MESH_RENDERER:
			{
				MeshRenderer meshRenderer = (MeshRenderer)theEObject;
				T1 result = caseMeshRenderer(meshRenderer);
				if (result == null) result = caseGenericRenderer(meshRenderer);
				if (result == null) result = caseGraphicsPipeline(meshRenderer);
				if (result == null) result = caseMaintainer(meshRenderer);
				if (result == null) result = caseVkPipeline(meshRenderer);
				if (result == null) result = caseMaintainable(meshRenderer);
				if (result == null) result = caseTaskPipeline(meshRenderer);
				if (result == null) result = caseAbstractPipeline(meshRenderer);
				if (result == null) result = caseIResourceContainer(meshRenderer);
				if (result == null) result = caseLNamedElement(meshRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ShapePackage.MESH_STRUCTURE:
			{
				MeshStructure<?> meshStructure = (MeshStructure<?>)theEObject;
				T1 result = caseMeshStructure(meshStructure);
				if (result == null) result = caseIMeshStructure(meshStructure);
				if (result == null) result = caseStructure(meshStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ShapePackage.IMESH_STRUCTURE:
			{
				IMeshStructure iMeshStructure = (IMeshStructure)theEObject;
				T1 result = caseIMeshStructure(iMeshStructure);
				if (result == null) result = caseStructure(iMeshStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ShapePackage.GEOMETRIC_STRUCTURE:
			{
				GeometricStructure geometricStructure = (GeometricStructure)theEObject;
				T1 result = caseGeometricStructure(geometricStructure);
				if (result == null) result = caseMeshStructure(geometricStructure);
				if (result == null) result = caseIMeshStructure(geometricStructure);
				if (result == null) result = caseStructure(geometricStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ShapePackage.GEOMETRIC_MESH:
			{
				GeometricMesh geometricMesh = (GeometricMesh)theEObject;
				T1 result = caseGeometricMesh(geometricMesh);
				if (result == null) result = caseMesh(geometricMesh);
				if (result == null) result = casePresentation(geometricMesh);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ShapePackage.ICOSAHEDRON:
			{
				Icosahedron icosahedron = (Icosahedron)theEObject;
				T1 result = caseIcosahedron(icosahedron);
				if (result == null) result = caseGeometricStructure(icosahedron);
				if (result == null) result = caseMeshStructure(icosahedron);
				if (result == null) result = caseIMeshStructure(icosahedron);
				if (result == null) result = caseStructure(icosahedron);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ShapePackage.SPHERE:
			{
				Sphere sphere = (Sphere)theEObject;
				T1 result = caseSphere(sphere);
				if (result == null) result = caseGeometricStructure(sphere);
				if (result == null) result = caseMeshStructure(sphere);
				if (result == null) result = caseIMeshStructure(sphere);
				if (result == null) result = caseStructure(sphere);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ShapePackage.ICO_SPHERE:
			{
				IcoSphere icoSphere = (IcoSphere)theEObject;
				T1 result = caseIcoSphere(icoSphere);
				if (result == null) result = caseGeometricStructure(icoSphere);
				if (result == null) result = caseMeshStructure(icoSphere);
				if (result == null) result = caseIMeshStructure(icoSphere);
				if (result == null) result = caseStructure(icoSphere);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mesh</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mesh</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMesh(Mesh object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mesh Renderer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mesh Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMeshRenderer(MeshRenderer object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mesh Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mesh Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T extends Mesh> T1 caseMeshStructure(MeshStructure<T> object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IMesh Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IMesh Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIMeshStructure(IMeshStructure object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Geometric Structure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Geometric Structure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGeometricStructure(GeometricStructure object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Geometric Mesh</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Geometric Mesh</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseGeometricMesh(GeometricMesh object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Icosahedron</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Icosahedron</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIcosahedron(Icosahedron object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sphere</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sphere</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseSphere(Sphere object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ico Sphere</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ico Sphere</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIcoSphere(IcoSphere object)
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

} //ShapeSwitch
