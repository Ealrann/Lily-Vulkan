/**
 */
package org.sheepy.lily.vulkan.model.process;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.IResourceContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.TaskPipeline#getTaskPkgs <em>Task Pkgs</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getTaskPipeline()
 * @model abstract="true"
 * @generated
 */
public interface TaskPipeline extends AbstractPipeline, IResourceContainer
{
	/**
	 * Returns the value of the '<em><b>Task Pkgs</b></em>' containment reference list.
	 * The list contents are of type {@link org.sheepy.lily.vulkan.model.process.TaskPkg}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Task Pkgs</em>' containment reference list.
	 * @see org.sheepy.lily.vulkan.model.process.ProcessPackage#getTaskPipeline_TaskPkgs()
	 * @model containment="true"
	 * @generated
	 */
	EList<TaskPkg> getTaskPkgs();

} // TaskPipeline
