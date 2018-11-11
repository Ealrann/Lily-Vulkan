/**
 */
package org.sheepy.vulkan.model.process.compute.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.sheepy.vulkan.model.process.compute.ComputePackage;
import org.sheepy.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.vulkan.model.process.compute.ComputeProcessPool;
import org.sheepy.vulkan.model.process.impl.AbstractProcessPoolImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Pool</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ComputeProcessPoolImpl extends AbstractProcessPoolImpl<ComputeProcess> implements ComputeProcessPool
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputeProcessPoolImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return ComputePackage.Literals.COMPUTE_PROCESS_POOL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<ComputeProcess> getProcesses()
	{
		if (processes == null) {
			processes = new EObjectContainmentEList<ComputeProcess>(ComputeProcess.class, this, ComputePackage.COMPUTE_PROCESS_POOL__PROCESSES);
		}
		return processes;
	}

} //ComputeProcessPoolImpl
