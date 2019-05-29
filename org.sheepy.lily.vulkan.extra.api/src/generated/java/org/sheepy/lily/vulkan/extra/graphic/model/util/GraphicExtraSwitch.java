/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.sheepy.lily.core.model.types.LNamedElement;

import org.sheepy.lily.vulkan.extra.graphic.model.*;

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
 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage
 * @generated
 */
public class GraphicExtraSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GraphicExtraPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicExtraSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = GraphicExtraPackage.eINSTANCE;
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
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case GraphicExtraPackage.MESH_PROVIDER:
			{
				MeshProvider meshProvider = (MeshProvider)theEObject;
				T result = caseMeshProvider(meshProvider);
				if (result == null) result = caseLNamedElement(meshProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicExtraPackage.COMPLEX_MESH_PROVIDER:
			{
				ComplexMeshProvider complexMeshProvider = (ComplexMeshProvider)theEObject;
				T result = caseComplexMeshProvider(complexMeshProvider);
				if (result == null) result = caseMeshProvider(complexMeshProvider);
				if (result == null) result = caseLNamedElement(complexMeshProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicExtraPackage.IDATA_PROVIDER:
			{
				IDataProvider iDataProvider = (IDataProvider)theEObject;
				T result = caseIDataProvider(iDataProvider);
				if (result == null) result = caseLNamedElement(iDataProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicExtraPackage.VERTEX_DATA_PROVIDER:
			{
				VertexDataProvider vertexDataProvider = (VertexDataProvider)theEObject;
				T result = caseVertexDataProvider(vertexDataProvider);
				if (result == null) result = caseIDataProvider(vertexDataProvider);
				if (result == null) result = caseLNamedElement(vertexDataProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicExtraPackage.INDEX_DATA_PROVIDER:
			{
				IndexDataProvider indexDataProvider = (IndexDataProvider)theEObject;
				T result = caseIndexDataProvider(indexDataProvider);
				if (result == null) result = caseIDataProvider(indexDataProvider);
				if (result == null) result = caseLNamedElement(indexDataProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GraphicExtraPackage.UNIFORM_DATA_PROVIDER:
			{
				UniformDataProvider uniformDataProvider = (UniformDataProvider)theEObject;
				T result = caseUniformDataProvider(uniformDataProvider);
				if (result == null) result = caseIDataProvider(uniformDataProvider);
				if (result == null) result = caseLNamedElement(uniformDataProvider);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mesh Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mesh Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeshProvider(MeshProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Mesh Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Mesh Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexMeshProvider(ComplexMeshProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IData Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IData Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIDataProvider(IDataProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vertex Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vertex Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVertexDataProvider(VertexDataProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Index Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexDataProvider(IndexDataProvider object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Uniform Data Provider</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Uniform Data Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUniformDataProvider(UniformDataProvider object)
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
	public T caseLNamedElement(LNamedElement object)
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
	public T defaultCase(EObject object)
	{
		return null;
	}

} //GraphicExtraSwitch
