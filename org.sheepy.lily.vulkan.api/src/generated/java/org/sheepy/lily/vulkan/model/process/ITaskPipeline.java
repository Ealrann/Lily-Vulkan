/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.sheepy.lily.vulkan.model.IResourceContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ITask Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.ITaskPipeline#getTaskPkg <em>Task Pkg</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getITaskPipeline()
 * @model
 * @generated
 */
public interface ITaskPipeline extends IPipeline, IResourceContainer
{
	/**
	 * Returns the value of the '<em><b>Task Pkg</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Pkg</em>' containment reference.
	 * @see #setTaskPkg(TaskPkg)
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getITaskPipeline_TaskPkg()
	 * @model containment="true"
	 * @generated
	 */
	TaskPkg getTaskPkg();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.ITaskPipeline#getTaskPkg <em>Task Pkg</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Task Pkg</em>' containment reference.
	 * @see #getTaskPkg()
	 * @generated
	 */
	void setTaskPkg(TaskPkg value);

} // ITaskPipeline
