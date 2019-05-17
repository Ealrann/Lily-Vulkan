/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ITask Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.ITaskPkg#getTasks <em>Tasks</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getITaskPkg()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ITaskPkg extends EObject
{
	/**
	 * Returns the value of the '<em><b>Tasks</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.IPipelineTask}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tasks</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getITaskPkg_Tasks()
	 * @model containment="true"
	 * @generated
	 */
	EList<IPipelineTask> getTasks();

} // ITaskPkg
